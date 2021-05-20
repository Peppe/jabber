package com.example.application;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.Route;

@Route("login")

@Tag("login-view")
@JsModule("./src/login-view.ts")
public class LoginView extends Component implements HasSize, HasStyle {

    public LoginView() {
        // LoginI18n i18n = LoginI18n.createDefault();
        // i18n.setHeader(new LoginI18n.Header());
        // i18n.getHeader().setTitle("Spring Security - Flow Test Application");
        // i18n.getHeader().setDescription(
        // "Login using john/john (user) or emma/emma (admin)");
        // i18n.setAdditionalInformation(null);
        // setI18n(i18n);
        // setForgotPasswordButtonVisible(false);
        // setAction("login");
        // setOpened(true);
    }
}
