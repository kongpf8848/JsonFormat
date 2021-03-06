package io.github.kongpf8848.jsonformat.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import io.github.kongpf8848.jsonformat.panel.EditorTextPanel;
import io.github.kongpf8848.jsonformat.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class MinifyJsonAction extends AnAction {

    private JTextArea editorTextPanel;
    public static final String ACTION_TEXT = "Minify Json";

    public MinifyJsonAction(){

    }

    public MinifyJsonAction(JTextArea editorTextPanel) {
        this.editorTextPanel = editorTextPanel;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
         String text=this.editorTextPanel.getText();
        if (!StringUtils.isBlank(text)) {
            try {
                this.editorTextPanel.setText(JsonUtils.minifyJson(text));
            } catch (JsonProcessingException ex) {
                ex.printStackTrace();
            }
        }
    }
}
