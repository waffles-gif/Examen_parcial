package com.example.parcial.Controller;

@restController
@RequestMapping("/auth")
public class AuthController {

    private final AccountService accountService;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthController(AccountService accountService, AccountRepository accountRepository,
                          PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
                          JwtService jwtService) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequestDTO dto) {
        if (accountRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new AccountAlreadyExistsException("El email ya está registrado");
        }
        Account account = new Account();
        account.setEmail(dto.getEmail());
        account.setPassword(passwordEncoder.encode(dto.getPassword()));
        accountRepository.save(account);
        return ResponseEntity.status(201).body("Usuario registrado");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword())
        );

        UserDetails userDetails = accountService.loadUserByUsername(dto.getEmail());
        String token = jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
