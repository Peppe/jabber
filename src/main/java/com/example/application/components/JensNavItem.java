package com.example.application.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JensNavItem implements Serializable {
    private String path;
    private String title;
    private String icon;
    private Integer badge;
    private List<JensNavItem> children;

    public JensNavItem() {
        this.children = Collections.emptyList();
    }

    public JensNavItem(String path, String title) {
        this(path, title, (String) null, (Integer) null, (Collection) null);
    }

    public JensNavItem(String path, String title, String icon) {
        this(path, title, icon, (Integer) null, (Collection) null);
    }

    public JensNavItem(String path, String title, String icon, Integer badge) {
        this(path, title, icon, badge, (Collection) null);
    }

    public JensNavItem(String path, String title, String icon, Integer badge,
            Collection<JensNavItem> children) {
        this.children = Collections.emptyList();
        this.path = path;
        this.title = title;
        this.icon = icon;
        this.badge = badge;
        this.setChildren(children);
    }

    public String getPath() {
        return this.path;
    }

    public JensNavItem setPath(String path) {
        this.path = path;
        return this;
    }

    public String getTitle() {
        return this.title;
    }

    public JensNavItem setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIcon() {
        return this.icon;
    }

    public JensNavItem setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Integer getBadge() {
        return this.badge;
    }

    public JensNavItem setBadge(Integer badge) {
        this.badge = badge;
        return this;
    }

    public List<JensNavItem> getChildren() {
        return this.children;
    }

    public JensNavItem setChildren(JensNavItem... children) {
        return this.setChildren((Collection) Arrays.asList(children));
    }

    public JensNavItem setChildren(Collection<JensNavItem> children) {
        this.children = (List) (children != null ? new ArrayList(children)
                : Collections.emptyList());
        return this;
    }
}
