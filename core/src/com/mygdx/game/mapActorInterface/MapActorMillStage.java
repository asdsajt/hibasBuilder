package com.mygdx.game.mapActorInterface;

import com.mygdx.game.BuildigsClasses.Mill;
import com.mygdx.game.MyBaseClasses.MyLabel;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Vince on 2017. 01. 28..
 */

public class MapActorMillStage extends MapActorStage {

    private Mill mapactor;
    private OneSpriteStaticActor meat;
    private MyLabel label;

    public MapActorMillStage(MyGdxGame game, Mill m) {
        super(game, m);
        /*getActorGroup().addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MILL)){
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
        });
        allRemove();
        init();

        getActorGroup().addActor(meat);
        getActorGroup().addActor(label);*/
        allRemove();
        millIcon.setVisible(true);
    }

    @Override
    public void init() {
        super.init();

        /*meat = new OneSpriteStaticActor(Assets.manager.get(Assets.MEAT));
        meat.setSize(meret/2,meret/2);
        meat.setPosition(meret/4, getViewport().getWorldHeight()/2);

        label = new MyLabel("16 / day",labelStyle(80));
        label.setAlignment(Align.center);
        label.setPosition(meret/2-label.getWidth()/2,getViewport().getWorldHeight()/2-label.getHeight());*/

    }
}
