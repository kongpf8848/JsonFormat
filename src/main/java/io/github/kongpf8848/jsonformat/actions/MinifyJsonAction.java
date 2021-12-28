package io.github.kongpf8848.jsonformat.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import io.github.kongpf8848.jsonformat.panel.EditorTextPanel;
import org.jetbrains.annotations.NotNull;

public class MinifyJsonAction extends AnAction {

    private EditorTextPanel editorTextPanel;
    public static final String ACTION_TEXT = "Minify Json";

    public MinifyJsonAction(){

    }

    public MinifyJsonAction(EditorTextPanel editorTextPanel) {
        this.editorTextPanel = editorTextPanel;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {

    }
}
