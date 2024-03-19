module ru.browser.app.browser {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires javafx.web;

    opens ru.browser.app.browser to javafx.fxml;
    exports ru.browser.app.browser;
}