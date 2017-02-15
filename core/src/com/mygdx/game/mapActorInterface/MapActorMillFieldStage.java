package com.mygdx.game.mapActorInterface;

import com.mygdx.game.BuildigsClasses.MillCircle;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Vince on 2017. 01. 31..
 */

public class MapActorMillFieldStage extends MapActorStage {

    private MillCircle mapactor;

    public MapActorMillFieldStage(MyGdxGame game, MillCircle m) {
        super(game, m);
        /*getActorGroup().addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MILLMEZO)){
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
        millfieldIcon.setVisible(true);
    }
}

