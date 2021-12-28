package io.github.kongpf8848.jsonformat;

import com.intellij.openapi.project.Project;
import com.intellij.util.xml.ui.TextPanel;
import io.github.kongpf8848.jsonformat.panel.EditorTextPanel;

import javax.swing.*;
import java.awt.*;

public class JsonFormatToolWindow {

    private final JPanel panel=new JPanel(new GridLayout(0,1));
    private final JTextArea editorTextPanel;

    public JsonFormatToolWindow(Project project){
        this.editorTextPanel=new JTextArea();
        init();
    }

    private EditorTextPanel createEditorTextPanel(Project project) {
        return new EditorTextPanel(project);
    }

    private void init(){
        this.panel.add(this.editorTextPanel);
    }


    public JPanel getPanel() {
        return panel;
    }

    public JTextArea getEditorTextPanel() {
        return editorTextPanel;
    }
}


