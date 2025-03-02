package fin.org.trst.db.model;

import fin.org.trst.db.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "client_account")
public class ClientAccount {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "First name is required")
        @Size(max = 50)
        private String firstName;

        @NotBlank(message = "Last name is required")
        @Size(max = 50)
        private String lastName;

        @Email(message = "Invalid email format")
        @Column(unique = true)
        private String email;

        @NotBlank
        @Size(min = 8, max = 100)
        private String password;

        @Pattern(regexp = "^\\+?[0-9\\-\\s()]*$", message = "Invalid phone number")
        private String phoneNumber;

        @Past(message = "Date of birth must be in the past")
        private LocalDate dateOfBirth;

        @Column(precision = 12, scale = 2)
        private BigDecimal accountBalance;

        private boolean active;

        @Column(updatable = false)
        private LocalDateTime createdAt;

        private LocalDateTime updatedAt;

        @Min(0) @Max(5)
        private Double accountRating;

        @Enumerated(EnumType.STRING)
        private AccountType accountType;
}
