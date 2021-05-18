package com.example.application.views.main;

import java.util.Arrays;

import com.example.application.components.JensNav;
import com.example.application.components.JensNavItem;
import com.example.application.components.ThemeButton;

import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainView extends AppLayout {

    private H1 viewTitle;
    private Avatar avatar;
    private UserInfo localUser;
    private Span userLabel;

    public MainView() {
        localUser = new UserInfo("sprintingSquirrel", "Sprinting Squirrel",
                "https://i.pravatar.cc/150?img=54");
        UI.getCurrent().getElement().setAttribute("theme", "light-contrast");
        setPrimarySection(Section.DRAWER);
        addToNavbar(true, createHeaderContent());
        addToDrawer(createDrawerContent());
    }

    private Component createHeaderContent() {
        DrawerToggle drawerToggle = new DrawerToggle();
        drawerToggle.addClassNames("text-secondary");
        drawerToggle.setThemeName("contrast");

        viewTitle = new H1();
        viewTitle.addClassNames("m-0", "text-l", "flex-auto");

        Icon hashIcon = VaadinIcon.HASH.create();
        hashIcon.addClassNames("text-s", "pe-s", "text-secondary");

        Header layout = new Header();
        layout.addClassName("main-layout-header");
        layout.addClassNames("bg-base", "border-b", "border-contrast-10",
                "box-border", "flex", "h-xl", "px-m", "items-center", "w-full");

        layout.setWidthFull();
        ThemeButton button = new ThemeButton();

        layout.add(new DrawerToggle(), hashIcon, viewTitle, button);

        return layout;
    }

    private Component createDrawerContent() {
        VerticalLayout layout = new VerticalLayout();
        layout.addClassNames("main-layout-drawer");
        layout.setSizeFull();
        layout.setPadding(false);
        layout.setSpacing(false);

        Header header = new Header();
        header.addClassNames("flex", "items-center", "h-xl", "px-m", "space-s",
                "border-b", "border-contrast-10", "w-full", "box-border",
                "bg-contrast-10");
        header.addClassNames("main-layout-drawer-header");
        Icon icon = VaadinIcon.COMMENTS_O.create();
        icon.addClassNames("text-m");
        H2 text = new H2("Jabber");
        text.addClassNames("text-m", "m-0");
        header.add(icon, text);

        JensNav vaadinNav = new JensNav("Channels");
        vaadinNav.addClassNames("main-layout-drawer-nav");
        vaadinNav.addClassNames("w-full", "px-s", "box-border",
                "bg-contrast-10");
        vaadinNav.setItems(new JensNavItem("c/general", "general", "hash"),
                new JensNavItem("c/announcements", "announcements", "hash", 2),
                new JensNavItem("c/music", "music", "hash", 5),
                new JensNavItem("c/community", "community", "hash"),
                new JensNavItem("about", "About", "question", null,
                        Arrays.asList(
                                new JensNavItem("instructions", "Instructions",
                                        "newspaper", 4),
                                new JensNavItem("faq", "FAQ", "movie"))));

        Footer footer = createMenuFooter();
        layout.add(header, vaadinNav, footer); // TODO: menu,
        layout.expand(vaadinNav);
        return layout;
    }

    private Footer createMenuFooter() {
        avatar = new Avatar(localUser.getName(), localUser.getImage());
        avatar.addClassNames("mr-xs pointer");

        userLabel = new Span(localUser.getName());
        userLabel.addClassNames("font-medium", "text-s", "text-secondary");

        Footer footer = new Footer(avatar, userLabel);
        footer.addClassNames("main-layout-drawer-footer");
        footer.addClassNames("flex", "items-center", "px-m", "pointer", "h-xl",
                "bg-contrast-20", "w-full");
        footer.addClickListener(event -> {
            // footer.getUI().ifPresent(ui ->
            // ui.navigate(YourProfileView.class));
        });
        return footer;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        setViewTitle(getCurrentPageTitle());
    }

    public void setViewTitle(String title) {
        viewTitle.setText(title);
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass()
                .getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }

    public static MainView getInstance() {
        return (MainView) UI.getCurrent().getChildren()
                .filter(component -> component.getClass() == MainView.class)
                .findFirst().orElse(null);
    }
}