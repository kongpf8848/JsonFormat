package io.github.kongpf8848.jsonformat.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class ClearJsonAction extends AnAction {

    public static final String ACTION_TEXT = "Clear Editor Content";
    private JTextArea editorTextPanel;

    public ClearJsonAction() {
    }

    public ClearJsonAction(JTextArea editorTextPanel) {
        this.editorTextPanel = editorTextPanel;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        this.editorTextPanel.setText("");
    }
}
