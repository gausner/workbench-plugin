package com.myspace;

import com.myspace.exception.Failure;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
//import org.apache.maven.plugins.annotations.Mojo;
//import org.apache.maven.plugins.annotations.Parameter;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.kie.api.KieServices;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.builder.model.KieSessionModel;
import org.kie.api.conf.EqualityBehaviorOption;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.internal.utils.ServiceRegistry;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.kie.internal.io.ResourceFactory;

//@Mojo(name = "hello")
public class MyMojo extends AbstractMojo {
//    @Parameter(property = "msg", defaultValue = "from maven")
    private String msg;

    public void execute()
            throws MojoExecutionException {
        Weld w = new Weld();

        WeldContainer wc = w.initialize();
        WeldDrools app = wc.instance().select(WeldDrools.class).get();
        app.bootstrapDrools();

        w.shutdown();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}