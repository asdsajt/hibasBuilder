package com.mygdx.game.mapActorInterface;

import com.mygdx.game.BuildigsClasses.Hamu;
import com.mygdx.game.MyBaseClasses.MyLabel;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Vince on 2017. 02. 02..
 */

public class MapActorHamuStage extends MapActorStage {

    private Hamu mapactor;
    private OneSpriteStaticActor meat;
    private MyLabel label;

    public MapActorHamuStage(MyGdxGame game, Hamu h) {
        super(game, h);
        /*getActorGroup().addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.HAMU)) {
            @Override
            public void init() {
                super.init();
                setSize(meret / 2, meret / 2);
                setPosition(meret / 4, getViewport().getWorldHeight() - meret / 4 - getWidth());
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                    }
                });
            }
        });*/
        allRemove();
        ashIcon.setVisible(true);
    }
}
