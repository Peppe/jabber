package com.example.application.views.about;

import com.example.application.views.main.MainView;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "faq", layout = MainView.class)
@PageTitle("FAQ")
public class FaqView extends Div {

    public FaqView() {
        addClassName("about-view");
        add(new Text("Content placeholder"));
    }

}
