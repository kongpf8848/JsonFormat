package io.github.kongpf8848.jsonformat.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class CopyJsonAction extends AnAction {

    public static final String ACTION_TEXT = "Copy Editor Content to Clipboard";
    private static final String COPY_CONTENT_SUCCESS_MSG = "Copy content to Clipboard success.";
    private JTextArea editorTextPanel;

    public CopyJsonAction() {
    }

    public CopyJsonAction(JTextArea editorTextPanel) {
        this.editorTextPanel = editorTextPanel;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        String editorContent = this.editorTextPanel.getText();
        if (StringUtils.isNotBlank(editorContent)) {
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(editorContent),null);
        }
    }
}
