package com.example.application.components;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.data.renderer.ComponentRenderer;

public class ThemeButton extends Button {

    Dialog dialog;

    enum ChatThemeVariants {
        LIGHT("Light", "light"), LIGHT_CONTRAST("Light with contrast",
                "light-contrast"), DARK("Dark", "dark"), DARK_CONTRAST(
                        "Dark with contrast", "dark-contrast"), FIRE_DEPARTMENT(
                                "Fire department", "fire-department");

        String caption;
        String theme;

        ChatThemeVariants(String caption, String theme) {
            this.caption = caption;
            this.theme = theme;
        }
    }

    public ThemeButton() {
        dialog = new Dialog(createDialogLayout());
        setIcon(VaadinIcon.PAINT_ROLL.create());
        addThemeVariants(ButtonVariant.LUMO_ICON, ButtonVariant.LUMO_CONTRAST,
                ButtonVariant.LUMO_TERTIARY);
        addClickListener(buttonClickEvent -> {

            dialog.open();
            dialog.getElement().executeJs(
                    "$0.$.overlay.$.overlay.style['align-self'] = 'flex-start';"
                            + "$0.$.overlay.$.overlay.style['position'] = 'absolute';"
                            + "$0.$.overlay.$.overlay.style['top'] = ($1.getBoundingClientRect().bottom)+ 'px';"
                            + "$0.$.overlay.$.overlay.style['left'] = ($1.getBoundingClientRect().left - $0.$.overlay.$.overlay.getBoundingClientRect().width + $1.getBoundingClientRect().width- 32) + 'px';"
                            + "console.log($1.getBoundingClientRect())",
                    dialog, this);
            dialog.open();
        });
        dialog.setCloseOnEsc(true);
        dialog.addThemeName("transparent-curtain");
    }

    private Div createDialogLayout() {

        RadioButtonGroup<ChatThemeVariants> group = new RadioButtonGroup();
        group.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        group.setLabel("Choose theme");
        group.setItems(ChatThemeVariants.values());
        group.setValue(ChatThemeVariants.LIGHT_CONTRAST);
        group.setRenderer(
                new ComponentRenderer<>(theme -> new Text(theme.caption)));
        group.addValueChangeListener(event -> {
            UI.getCurrent().getElement().setAttribute("theme",
                    event.getValue().theme);
        });
        Div layout = new Div(group);
        return layout;
    }
}
