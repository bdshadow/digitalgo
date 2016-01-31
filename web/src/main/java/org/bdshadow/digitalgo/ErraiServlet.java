package org.bdshadow.digitalgo;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.jboss.errai.bus.server.servlet.DefaultBlockingServlet;

@WebServlet(name="ErraiServlet", urlPatterns={"*.erraiBus"}, loadOnStartup=1,
initParams={@WebInitParam(name="service-locator", value="org.jboss.errai.cdi.server.CDIServiceLocator")})
public class ErraiServlet extends DefaultBlockingServlet {


}
