package com.example.application.views.main;

import com.example.application.components.avataritem.AvatarItem;
import com.example.application.components.pricefield.PriceField;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.List;

@PageTitle("Main")
@Route(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class MainView extends Composite<VerticalLayout> {

    public MainView() {
        RouterLink routerLink = new RouterLink();
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        MultiSelectListBox avatarItems = new MultiSelectListBox();
        Button buttonSecondary = new Button();
        Button buttonSecondary2 = new Button();
        Button buttonSecondary3 = new Button();
        TextField textField = new TextField();
        PriceField price = new PriceField();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        FormLayout formLayout2Col = new FormLayout();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        routerLink.setText("Produkte");
        routerLink.setRoute(MainView.class);
        routerLink.setWidth("min-content");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn2.getStyle().set("flex-grow", "1");
        avatarItems.setWidth("min-content");
        avatarItems.setHeight("324px");
        setAvatarItemsSampleData(avatarItems);
        buttonSecondary.setText("Button");
        buttonSecondary.setWidth("min-content");
        buttonSecondary2.setText("Button");
        buttonSecondary2.setWidth("min-content");
        buttonSecondary3.setText("Button");
        buttonSecondary3.setWidth("min-content");
        textField.setLabel("Text field");
        textField.setWidth("min-content");
        price.setLabel("Preis");
        layoutColumn2.setAlignSelf(FlexComponent.Alignment.END, price);
        price.setWidth("min-content");
        layoutColumn4.setWidth("100%");
        layoutColumn4.getStyle().set("flex-grow", "1");
        layoutColumn3.getStyle().set("flex-grow", "1");
        formLayout2Col.setWidth("100%");
        getContent().add(routerLink);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(avatarItems);
        layoutColumn2.add(buttonSecondary);
        layoutColumn2.add(buttonSecondary2);
        layoutColumn2.add(buttonSecondary3);
        layoutColumn2.add(textField);
        layoutColumn2.add(price);
        layoutRow.add(layoutColumn4);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(formLayout2Col);
    }

    private void setAvatarItemsSampleData(MultiSelectListBox multiSelectListBox) {
        record Person(String name, String profession) {
        }
        ;
        List<Person> data = List.of(new Person("Aria Bailey", "Endocrinologist"), new Person("Aaliyah Butler", "Nephrologist"), new Person("Eleanor Price", "Ophthalmologist"), new Person("Allison Torres", "Allergist"), new Person("Madeline Lewis", "Gastroenterologist"));
        multiSelectListBox.setItems(data);
        multiSelectListBox.setRenderer(new ComponentRenderer(item -> {
            AvatarItem avatarItem = new AvatarItem();
            avatarItem.setHeading(((Person) item).name);
            avatarItem.setDescription(((Person) item).profession);
            avatarItem.setAvatar(new Avatar(((Person) item).name));
            return avatarItem;
        }));
    }
}
