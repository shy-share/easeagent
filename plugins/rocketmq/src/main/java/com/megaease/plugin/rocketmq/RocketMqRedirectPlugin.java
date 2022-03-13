package com.megaease.plugin.rocketmq;

import com.megaease.easeagent.plugin.AgentPlugin;
import com.megaease.easeagent.plugin.api.config.ConfigConst;
import com.megaease.easeagent.plugin.api.config.ConfigConst.Namespace;

public class RocketMqRedirectPlugin  implements AgentPlugin {
    @Override
    public String getNamespace() {
        return Namespace.ROCKETMQ;
    }

    @Override
    public String getDomain() {
        return ConfigConst.INTEGRABILITY;
    }
}
