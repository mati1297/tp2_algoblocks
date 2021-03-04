package algoblocks.engine.action;

import algoblocks.engine.player.Player;

public abstract class Action {
    public abstract void execute(Player player);

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass())
            return false;

        return true;
    }
}