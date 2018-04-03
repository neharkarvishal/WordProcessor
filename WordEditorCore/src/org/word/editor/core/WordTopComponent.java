package org.word.editor.core;

import java.util.Collection;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;
import org.openide.windows.TopComponent;
import org.openide.util.NbBundle.Messages;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.word.editor.api.WordFilter;

/** * Top component which displays something. */
@ConvertAsProperties(
        dtd = "-//org.word.editor.core//Word//EN",
        autostore = false
)
@TopComponent.Description(
        preferredID = "WordTopComponent",
        //iconBase = "org/word/editor/core/folded-document-icon.png",
        persistenceType = TopComponent.PERSISTENCE_ALWAYS
)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "org.word.editor.core.WordTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(
        displayName = "#CTL_WordAction",
        preferredID = "WordTopComponent"
)
@Messages({
    "CTL_WordAction=Word",
    "CTL_WordTopComponent=Word Window",
    "HINT_WordTopComponent=This is a Word window"
})



public final class WordTopComponent extends TopComponent {
    
    private InstanceContent content;

    private WordTopComponent() 
    {
     initComponents();
     setName(Bundle.CTL_WordTopComponent());
     setToolTipText(Bundle.HINT_WordTopComponent());
     content = new InstanceContent();
     associateLookup(new AbstractLookup(content));
    }

    /*public WordTopComponent() {
        initComponents();
        setName(Bundle.CTL_WordTopComponent());
        setToolTipText(Bundle.HINT_WordTopComponent());

    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        org.openide.awt.Mnemonics.setLocalizedText(jButton1, org.openide.util.NbBundle.getMessage(WordTopComponent.class, "WordTopComponent.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String enteredText = text.getText();
        Collection<? extends WordFilter> allFilters = Lookup.getDefault().lookupAll(WordFilter.class);
        StringBuilder sb = new StringBuilder();
        for (WordFilter textFilter : allFilters) 
        {
            String processedText = textFilter.process(enteredText);
            sb.append(processedText).append("\n");
          content.add(enteredText);
        }
        text.setText(sb.toString());       
        
        //  String s = text.getText();
        //  s = s.toUpperCase();
        //  text.setText(s);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}