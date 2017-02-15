package com.mygdx.game.mapActorInterface;

import com.mygdx.game.BuildigsClasses.WaterWell;
import com.mygdx.game.MyBaseClasses.MyLabel;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Vince on 2017. 01. 28..
 */

public class MapActorWaterWellStage extends MapActorStage {

    private WaterWell mapactor;
    private MyLabel label;

    public MapActorWaterWellStage(MyGdxGame game, final WaterWell w) {
        super(game, w);
        allRemove();
        waterwellIcon.setVisible(true);
        /*getActorGroup().addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.WATER_WELL)){
            @Override
            public void init() {
                super.init();
                setSize(width/2, width/2);
                setPosition(width/4, getViewport().getWorldHeight()-width/4-getWidth());
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
        getActorGroup().addActor(label);*/
    }

    @Override
    public void init() {
        super.init();

        /*label = new MyLabel("Protect\n5 buildings",labelStyle(60));
        label.setAlignment(Align.center);
        label.setPosition(meret/2-label.getWidth()/2,getViewport().getWorldHeight()/2-label.getHeight()/2);*/
    }
}
