package io.github.kongpf8848.jsonformat;

import com.intellij.icons.AllIcons;
import com.intellij.ide.actions.CopyAction;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.openapi.wm.ex.ToolWindowEx;
import com.intellij.ui.content.ContentFactory;
import io.github.kongpf8848.jsonformat.actions.ClearJsonAction;
import io.github.kongpf8848.jsonformat.actions.CopyJsonAction;
import io.github.kongpf8848.jsonformat.actions.FormatJsonAction;
import io.github.kongpf8848.jsonformat.actions.MinifyJsonAction;
import io.github.kongpf8848.jsonformat.panel.EditorTextPanel;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class JsonFormatToolWindowFactory implements ToolWindowFactory {
    private static final String DISPLAY_NAME = "";

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        JsonFormatToolWindow window = new JsonFormatToolWindow(project);
        toolWindow.getContentManager().addContent(ContentFactory.SERVICE.getInstance().createContent(window.getPanel(), DISPLAY_NAME, true));
        initAction(toolWindow, window.getEditorTextPanel());
    }

    private void initAction(ToolWindow toolWindow, JTextArea editorTextPanel) {
        FormatJsonAction formatJsonAction = new FormatJsonAction(editorTextPanel);
        formatJsonAction.getTemplatePresentation().setIcon(AllIcons.Actions.Expandall);
        formatJsonAction.getTemplatePresentation().setText(FormatJsonAction.ACTION_TEXT);
        MinifyJsonAction minifyJsonAction = new MinifyJsonAction(editorTextPanel);
        minifyJsonAction.getTemplatePresentation().setIcon(AllIcons.Actions.Collapseall);
        minifyJsonAction.getTemplatePresentation().setText(MinifyJsonAction.ACTION_TEXT);
        CopyJsonAction copyJsonAction = new CopyJsonAction(editorTextPanel);
        copyJsonAction.getTemplatePresentation().setIcon(AllIcons.Actions.Copy);
        copyJsonAction.getTemplatePresentation().setText(CopyJsonAction.ACTION_TEXT);
        ClearJsonAction clearJsonAction = new ClearJsonAction(editorTextPanel);
        clearJsonAction.getTemplatePresentation().setIcon(AllIcons.Actions.Cancel);
        clearJsonAction.getTemplatePresentation().setText(ClearJsonAction.ACTION_TEXT);
        toolWindow.setTitleActions(List.of(formatJsonAction,minifyJsonAction,copyJsonAction,clearJsonAction));
    }
}
