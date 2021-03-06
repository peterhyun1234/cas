package org.apereo.cas.adaptors.yubikey.web.flow;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.web.flow.configurer.AbstractMultifactorTrustedDeviceWebflowConfigurer;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;

import java.util.Optional;

/**
 * This is {@link YubiKeyMultifactorTrustWebflowConfigurer}.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
public class YubiKeyMultifactorTrustWebflowConfigurer extends AbstractMultifactorTrustedDeviceWebflowConfigurer {

    public YubiKeyMultifactorTrustWebflowConfigurer(final FlowBuilderServices flowBuilderServices,
                                                    final boolean deviceRegistrationEnabled,
                                                    final FlowDefinitionRegistry flowDefinitionRegistry,
                                                    final FlowDefinitionRegistry loginFlowDefinitionRegistry,
                                                    final ConfigurableApplicationContext applicationContext,
                                                    final CasConfigurationProperties casProperties) {
        super(flowBuilderServices, loginFlowDefinitionRegistry, deviceRegistrationEnabled,
            applicationContext, casProperties, Optional.of(flowDefinitionRegistry));
    }

    @Override
    protected void doInitialize() {
        registerMultifactorTrustedAuthentication();
    }
}

