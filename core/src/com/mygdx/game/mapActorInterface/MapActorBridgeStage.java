package com.mygdx.game.mapActorInterface;

import com.mygdx.game.BuildigsClasses.Bridge;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Vince on 2017. 01. 28..
 */

public class MapActorBridgeStage extends MapActorStage {

    private Bridge mapactor;

    public MapActorBridgeStage(MyGdxGame game, Bridge b) {
        super(game, b);
        /*getActorGroup().addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BRIDGE)){
            @Override
            public void init() {
                super.init();
                setSize(meret/2, meret/2);
                setPosition(meret/4, getViewport().getWorldHeight()-meret/4-getWidth());
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                    }
                });
            }
        });*/
        allRemove();
        bridgeIcon.setVisible(true);
    }
}
