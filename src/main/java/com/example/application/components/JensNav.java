//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.application.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;

import elemental.json.Json;
import elemental.json.JsonArray;
import elemental.json.JsonObject;

@Tag("jens-nav")
@JsModule("./src/jens-nav/jens-nav.ts")
public class JensNav extends LitTemplate implements HasSize, HasStyle {
    List<JensNavItem> items = Collections.emptyList();
    private boolean pendingUpdate = false;

    public JensNav() {
    }

    public JensNav(String label) {
        this.setLabel(label);
    }

    public void setLabel(String label) {
        this.getElement().setProperty("label", label);
    }

    public String getLabel() {
        return this.getElement().getProperty("label", (String) null);
    }

    public void setItems(JensNavItem... items) {
        this.setItems((Collection) Arrays.asList(items));
    }

    public void setItems(Collection<JensNavItem> items) {
        this.items = new ArrayList(items);
        this.setClientItems();
    }

    public List<JensNavItem> getItems() {
        return this.items;
    }

    private void setClientItems() {
        if (!this.pendingUpdate) {
            this.pendingUpdate = true;
            this.getElement().getNode().runWhenAttached((ui) -> {
                ui.beforeClientResponse(this, (ctx) -> {
                    this.getElement().setPropertyJson("items",
                            this.createItemsJsonArray(this.items));
                    this.pendingUpdate = false;
                });
            });
        }

    }

    private JsonArray createItemsJsonArray(Collection<JensNavItem> items) {
        JsonArray jsonItems = Json.createArray();

        JsonObject jsonItem;
        for (Iterator var3 = items.iterator(); var3.hasNext(); jsonItems
                .set(jsonItems.length(), jsonItem)) {
            JensNavItem item = (JensNavItem) var3.next();
            jsonItem = Json.createObject();
            if (item.getPath() != null) {
                jsonItem.put("path", item.getPath());
            }

            if (item.getTitle() != null) {
                jsonItem.put("title", item.getTitle());
            }

            if (item.getIcon() != null) {
                jsonItem.put("icon", item.getIcon());
            }

            if (item.getBadge() != null) {
                jsonItem.put("badge", (double) item.getBadge());
            }

            if (item.getChildren() != null && !item.getChildren().isEmpty()) {
                JsonArray children = this
                        .createItemsJsonArray(item.getChildren());
                jsonItem.put("children", children);
            }
        }

        return jsonItems;
    }
}
