package com.github.thomasdarimont.keycloak.custom.consent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.keycloak.models.UserModel;

@Data
public class ScopeFieldBean {

    @JsonIgnore
    private final ProfileAttribute attribute;

    @JsonIgnore
    private final UserModel user;

    public String getName() {
        return attribute.getName();
    }

    public String getType() {
        return attribute.getType();
    }

    public String getValue() {
        if (attribute instanceof KeycloakProfileAttribute) {
            return ((KeycloakProfileAttribute)attribute).getValue(user);
        }
        return attribute.getValue();
    }

    public boolean isRequired() {
        return attribute.isRequired();
    }

    public boolean isReadonly() {
        return attribute.isReadonly();
    }
}
