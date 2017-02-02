package controller;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.TransferHandler;

import model.Model;

@SuppressWarnings("serial")
final class FileDropHandler extends TransferHandler {
	
	Model model;
	String username;
	
    @Override
    public boolean canImport(TransferHandler.TransferSupport support) {
        for (DataFlavor flavor : support.getDataFlavors()) {
            if (flavor.isFlavorJavaFileListType()) {
                return true;
            }
        }
        return false;
    }
    
    public FileDropHandler(String username, Model model){
    	this.username=username;
    	this.model=model;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean importData(TransferHandler.TransferSupport support) {
        if (!this.canImport(support))
            return false;

        List<File> files;
        try {
            files = (List<File>) support.getTransferable()
                    .getTransferData(DataFlavor.javaFileListFlavor);
        } catch (UnsupportedFlavorException | IOException ex) {
            // should never happen (or JDK is buggy)
            return false;
        }

        for (File file: files) {
        	System.out.println(file);
       // 	model.addFile(username, file.getName());
         	model.addFile(username, file);
        	
        	
        	
        }
        return true;
    }
}