package algoblocks.view.workspace;

import algoblocks.view.workspace.block.ActionBlockItem;
import algoblocks.view.workspace.block.BlockItem;
import algoblocks.view.workspace.block.EffectBlockItem;
import javafx.scene.control.ListView;

import java.util.ArrayList;

import algoblocks.engine.block.*;

public class WorkspaceView {
    private ListView<BlockItem> listView;
    private ArrayList<EffectBlockItem> openedItems;

    public WorkspaceView() {
        listView = new ListView<BlockItem>();
        openedItems = new ArrayList<EffectBlockItem>();
    }

    public void setPrefHeight (Double prefHeight) {
        listView.setPrefHeight(prefHeight);
    }

    public void setPrefWidth (Double prefWidth) {
        listView.setPrefWidth(prefWidth);
    }

    public void addActionBlock(Block block) {
        if(!openedItems.isEmpty())
            openedItems.get(openedItems.size() - 1).addChild(new ActionBlockItem(block));
        else
            listView.getItems().add(new ActionBlockItem(block));
        listView.refresh();
    }

    public void addEffectBlock(Block block) {
        EffectBlockItem newEffectBlockItem = new EffectBlockItem(block, openedItems.size());

        if(!openedItems.isEmpty())
            openedItems.get(openedItems.size() - 1).addChild(newEffectBlockItem);
        else
            listView.getItems().add(newEffectBlockItem);

        openedItems.add(newEffectBlockItem);
        listView.refresh();
    }

    public boolean remove(int index) {
        boolean opened = false;
        BlockItem item = listView.getItems().get(index);
        if(item instanceof EffectBlockItem) {
            EffectBlockItem effectBlockItem = (EffectBlockItem) item;
            if(opened = effectBlockItem.isOpened()) {
                System.out.println("Entre");
                openedItems.clear();
            }
        }
        listView.getItems().remove(index);
        return opened;
    }

    public ListView<BlockItem> getListView() {
        return listView;
    }

    public void clear() {
        listView.getItems().clear();
        closeAllEffectBlocks();
    }

    public void closeAllEffectBlocks() {
        while(!openedItems.isEmpty()) {
            EffectBlockItem item = openedItems.get(openedItems.size() - 1);
            openedItems.remove(item);
            item.close();
        }
        listView.refresh();
    }

    public void closeEffectBlock() {
        if(!openedItems.isEmpty()) {
            EffectBlockItem item = openedItems.get(openedItems.size() - 1);
            openedItems.remove(item);
            item.close();
        }
        listView.refresh();
    }

    public int getSelectedIndex() {
        return listView.getSelectionModel().getSelectedIndex();
    }
}