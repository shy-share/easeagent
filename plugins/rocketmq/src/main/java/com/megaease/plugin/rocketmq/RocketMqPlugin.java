package com.megaease.plugin.rocketmq;

import com.megaease.easeagent.plugin.AgentPlugin;
import com.megaease.easeagent.plugin.api.config.ConfigConst;


public class RocketMqPlugin implements AgentPlugin {

    @Override
    public String getNamespace() {
        return ConfigConst.Namespace.ROCKETMQ;
    }

    @Override
    public String getDomain() {
        return ConfigConst.OBSERVABILITY;
    }
}
