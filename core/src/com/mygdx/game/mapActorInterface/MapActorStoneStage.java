package com.mygdx.game.mapActorInterface;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Play.stoneActor;

/**
 * Created by tuskeb on 2017. 01. 26..
 */

public class MapActorStoneStage extends MapActorStage {




    public MapActorStoneStage(MyGdxGame game, stoneActor g) {
        super(game, g);
        allRemove();
        if(!g.isFog()) stoneIcon.setVisible(true);
        else fogtext.setVisible(true);
            /*getActorGroup().addActor(new OneSpriteStaticActor(g.getStone()){
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
        //allRemove();
    }
}
