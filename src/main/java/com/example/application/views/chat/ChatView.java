package com.example.application.views.chat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import com.example.application.views.main.MainView;

import com.vaadin.collaborationengine.CollaborationMessageInput;
import com.vaadin.collaborationengine.CollaborationMessageList;
import com.vaadin.collaborationengine.UserInfo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "c/:channel?", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
public class ChatView extends HorizontalLayout implements BeforeEnterObserver,
        AfterNavigationObserver, HasDynamicTitle {

    private final CollaborationMessageList list;
    private String currentChannel = "general";

    public ChatView() {
        UserInfo userInfo = new UserInfo(UUID.randomUUID().toString(),
                "Steve Lange");

        list = new CollaborationMessageList(userInfo, "c/general");
        list.setWidthFull();
        list.addClassNames("chat-view-message-list");

        CollaborationMessageInput input = new CollaborationMessageInput(list);
        input.addClassNames("chat-view-message-input");
        input.setWidthFull();

        // Fake components that can be used if you just want example messages on
        // the screen for developing
        MessageList dummyList = dummyMessageList();
        MessageInput dummyInput = dummyMessageInput(dummyList);

        // (dummyList, dummyInput);
        VerticalLayout chatLayout = new VerticalLayout(dummyList, dummyInput);
        chatLayout.setSpacing(false);
        chatLayout.setPadding(false);
        chatLayout.setSizeFull();
        chatLayout.expand(dummyList);

        VerticalLayout memberList = getMemberList();
        add(chatLayout, memberList);
        setSpacing(false);
        setSizeFull();
        expand(chatLayout);
    }

    private VerticalLayout getMemberList() {
        VerticalLayout memberList = new VerticalLayout();
        Label onlineNowLabel = new Label("Online now");
        onlineNowLabel.addClassNames("text-s", "text-secondary", "font-medium",
                "p-s", "leading-xs");
        memberList.add(onlineNowLabel);
        memberList.add(dummyAvatarComponent("Danny Stego",
                "https://i.pravatar.cc/150?img=61"));
        memberList.add(dummyAvatarComponent("Albi Mccray",
                "https://i.pravatar.cc/150?img=45"));
        memberList.add(dummyAvatarComponent("Casey Kim",
                "https://i.pravatar.cc/150?img=36"));
        memberList.add(dummyAvatarComponent("Drew Archer",
                "https://i.pravatar.cc/150?img=66"));
        memberList.add(dummyAvatarComponent("Kitty Mcfarland",
                "https://i.pravatar.cc/150?img=32"));
        memberList.setWidth("300px");
        memberList.addClassNames("bg-contrast-5", "border-l",
                "border-contrast-10", "pt-s");
        return memberList;
    }

    private Component dummyAvatarComponent(String name, String avatarUrl) {
        Avatar avatar = new Avatar(name, avatarUrl);
        Label label = new Label(name);
        label.addClassNames("font-medium");
        HorizontalLayout layout = new HorizontalLayout(avatar, label);
        layout.setAlignItems(Alignment.CENTER);
        return layout;
    }

    private MessageList dummyMessageList() {
        Random r = new Random();
        LocalDateTime time = LocalDateTime.now();
        MessageList dummyList = new MessageList();
        dummyList.setWidthFull();
        dummyList.setItems(
                new MessageListItem(
                        "Hello to our *house*. Do you feel *better* yet?",
                        time.minusMinutes(83).minusSeconds(r.nextInt(60))
                                .toInstant(ZoneOffset.UTC),
                        "Danny Stego", "https://i.pravatar.cc/150?img=61"),
                new MessageListItem(
                        "If you are *campers* you will enjoy *the change*, but maybe not yet.",
                        time.minusMinutes(82).minusSeconds(r.nextInt(60))
                                .toInstant(ZoneOffset.UTC),
                        "Danny Stego", "https://i.pravatar.cc/150?img=61"),
                new MessageListItem(
                        "It is best if many happy Orz are coming to your *house*.",
                        time.minusMinutes(77).minusSeconds(r.nextInt(60))
                                .toInstant(ZoneOffset.UTC),
                        "Albi Mccray", "https://i.pravatar.cc/150?img=45"),
                new MessageListItem(
                        "You are so many *lonely* *juicy* *bubbles*. It is so sad.",
                        time.minusMinutes(75).minusSeconds(r.nextInt(60))
                                .toInstant(ZoneOffset.UTC),
                        "Casey Kim", "https://i.pravatar.cc/150?img=36"),
                new MessageListItem(
                        "Now that you are *campers* you will have more *parties* and no more *sad* *lonely* *bubbles*.",
                        time.minusMinutes(74).minusSeconds(r.nextInt(60))
                                .toInstant(ZoneOffset.UTC),
                        "Casey Kim", "https://i.pravatar.cc/150?img=36"),
                new MessageListItem("This is the *secret*.",
                        time.minusMinutes(53).minusSeconds(r.nextInt(60))
                                .toInstant(ZoneOffset.UTC),
                        "Drew Archer", "https://i.pravatar.cc/150?img=66"),
                new MessageListItem(
                        "Happy to come to my *house* some more times. I am Orz. I do not have the name because I am Orz. Orz is the name.",
                        time.minusMinutes(50).minusSeconds(r.nextInt(60))
                                .toInstant(ZoneOffset.UTC),
                        "Casey Kim", "https://i.pravatar.cc/150?img=36"),
                new MessageListItem(
                        "Oh, the *alliance party* *campers* are in the *now space*.",
                        time.minusMinutes(33).minusSeconds(r.nextInt(60))
                                .toInstant(ZoneOffset.UTC),
                        "Kitty Mcfarland", "https://i.pravatar.cc/150?img=32"),
                new MessageListItem("It is *happy spices*. Why are you there?",
                        time.minusMinutes(31).minusSeconds(r.nextInt(60))
                                .toInstant(ZoneOffset.UTC),
                        "Kitty Mcfarland", "https://i.pravatar.cc/150?img=32"),
                new MessageListItem(
                        "Of course because also the Orz are in the *now space*.",
                        time.minusMinutes(15).minusSeconds(r.nextInt(60))
                                .toInstant(ZoneOffset.UTC),
                        "Danny Stego", "https://i.pravatar.cc/150?img=61"));
        return dummyList;
    }

    private MessageInput dummyMessageInput(MessageList dummyList) {
        MessageInput dummyInput = new MessageInput();
        dummyInput.addClassNames("chat-view-message-input");
        dummyInput.setWidthFull();
        dummyInput.addSubmitListener(event -> {
            List<MessageListItem> items = dummyList.getItems();
            items.add(new MessageListItem(event.getValue(), Instant.now(),
                    "Sprinting Squirrel", "https://i.pravatar.cc/150?img=54"));
            dummyList.setItems(items);
        });
        dummyInput.addClassNames("h-xl", "bg-contrast-20");
        return dummyInput;
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
    }

    @Override
    public String getPageTitle() {
        return currentChannel;
    }

    @Override
    public void afterNavigation(AfterNavigationEvent event) {
        MainView mainView = MainView.getInstance();
        if (mainView != null) {
            mainView.setViewTitle(currentChannel);
        }
        Optional<String> channel = event.getLocationChangeEvent()
                .getQueryParameter("channel");
        if (channel.isPresent()) {
            currentChannel = channel.get();
        } else {
            currentChannel = "general";
        }

        list.setTopic("c/" + currentChannel);
    }
}
