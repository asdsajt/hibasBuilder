package com.mygdx.game.mapActorInterface;

import com.mygdx.game.BuildigsClasses.House;
import com.mygdx.game.MyBaseClasses.MyLabel;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;

/**
 * Created by Vince on 2017. 01. 28..
 */

public class MapActorHouseStage extends MapActorStage {

    private House mapactor;
    private OneSpriteStaticActor person,coin;
    private MyLabel label,coinLabel;

    public MapActorHouseStage(MyGdxGame game, House h) {
        super(game, h);
        /*getActorGroup().addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.HOUSE)){
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

        getActorGroup().addActor(person);
        getActorGroup().addActor(label);
        getActorGroup().addActor(coin);
        getActorGroup().addActor(coinLabel);*/
        allRemove();
        houseIcon.setVisible(true);
    }

    @Override
    public void init() {
        super.init();

        /*coinLabel = new MyLabel("2 / day",labelStyle(80));
        coinLabel.setPosition(meret/2-coinLabel.getWidth()/2, getViewport().getWorldHeight()/2-meret/2);

        coin = new OneSpriteStaticActor(Assets.manager.get(Assets.ARANY));
        coin.setSize(meret/2,meret/2);
        coin.setPosition(meret/4, getViewport().getWorldHeight()/2-meret/2+coinLabel.getHeight());

        person = new OneSpriteStaticActor(Assets.manager.get(Assets.PEOPLE));
        person.setSize(meret/2,meret/2);
        person.setPosition(meret/4, getViewport().getWorldHeight()/2-meret/2-person.getHeight());

        label = new MyLabel("1 / day",labelStyle(80));
        label.setAlignment(Align.center);
        label.setPosition(meret/2-label.getWidth()/2, getViewport().getWorldHeight()/2-meret/2-person.getHeight()-label.getHeight());*/

    }
}
