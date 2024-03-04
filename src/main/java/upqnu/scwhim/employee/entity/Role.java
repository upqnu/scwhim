package upqnu.scwhim.employee.entity;

import lombok.Getter;

@Getter
public enum Role {

    MANAGER("팀장"),
    MATE("팀원");

    private final String role;

    Role(String role) {
        this.role = role;
    }
}
