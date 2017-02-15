package com.mygdx.game.mapActorInterface;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Play.grassActor;

/**
 * Created by Kicsi on 2017. 01. 26..
 */

public class MapActorGrassStage extends MapActorStage {

    //private float meretek = (meret / 2) / 4;
    //private AnyagokStage hazanyag,banyaszanyag,favagoanyag,kardanyag,kapaanyag,kutanyag;
    private grassActor g;

    public MapActorGrassStage(MyGdxGame game, grassActor g) {
        super(game, g);
        this.g = g;

    }

        //f,k,a,h,l

        /*hazanyag = new AnyagokStage(getViewport(),100,100, Buildings.haz.getLetrehoz()[2], Buildings.haz.getLetrehoz()[3], Buildings.haz.getLetrehoz()[4], Buildings.haz.getLetrehoz()[1], Buildings.haz.getLetrehoz()[0]);
        hazanyag.setSize(100,100);
        hazanyag.setPosition(0,0);
        addActor(hazanyag);

        banyaszanyag = new AnyagokStage(getViewport(),100,-28, Buildings.banya.getLetrehoz()[2], Buildings.banya.getLetrehoz()[3], Buildings.banya.getLetrehoz()[4], Buildings.banya.getLetrehoz()[1], Buildings.banya.getLetrehoz()[0]);
        banyaszanyag.setSize(100,100);
        banyaszanyag.setPosition(0,0);
        addActor(banyaszanyag);

        favagoanyag = new AnyagokStage(getViewport(),100,-28-128, Buildings.faKitermelo.getLetrehoz()[2], Buildings.faKitermelo.getLetrehoz()[3], Buildings.faKitermelo.getLetrehoz()[4], Buildings.faKitermelo.getLetrehoz()[1], Buildings.faKitermelo.getLetrehoz()[0]);
        favagoanyag.setSize(100,100);
        favagoanyag.setPosition(0,0);
        addActor(favagoanyag);

        kardanyag = new AnyagokStage(getViewport(),100,-28-(128*2), Buildings.kikepzo.getLetrehoz()[2], Buildings.kikepzo.getLetrehoz()[3], Buildings.kikepzo.getLetrehoz()[4], Buildings.kikepzo.getLetrehoz()[1], Buildings.kikepzo.getLetrehoz()[0]);
        kardanyag.setSize(100,100);
        kardanyag.setPosition(0,0);
        addActor(kardanyag);

        kapaanyag = new AnyagokStage(getViewport(),100,-28-(128*3), Buildings.farmnagy.getLetrehoz()[2], Buildings.farmnagy.getLetrehoz()[3], Buildings.farmnagy.getLetrehoz()[4], Buildings.farmnagy.getLetrehoz()[1], Buildings.farmnagy.getLetrehoz()[0]);
        kapaanyag.setSize(100,100);
        kapaanyag.setPosition(0,0);
        addActor(kapaanyag);

        kutanyag = new AnyagokStage(getViewport(),100,-28-(128*4), Buildings.kut.getLetrehoz()[2], Buildings.kut.getLetrehoz()[3], Buildings.kut.getLetrehoz()[4], Buildings.kut.getLetrehoz()[1], Buildings.kut.getLetrehoz()[0]);
        kutanyag.setSize(100,100);
        kutanyag.setPosition(0,0);
        addActor(kutanyag);*/

    @Override
    public void init() {
        super.init();

        allRemove();
        grassBuildings();

        /*if (!g.isFog()) {
            //standardBuildings();
            System.out.println("asd");
            allRemove();
            grassBuildings();

            boolean bWoodCutter = false;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (g.getPosArrayX() + i < PlayStage.mapWidth && g.getPosArrayX() + i > 0 && g.getPosArrayY() + j < PlayStage.mapHeight && g.getPosArrayY() + j > 0)
                        //if(g.getPosArrayY() < PlayStage.mapHeight-1 && g.getPosArrayY() > 0 && g.getPosArrayX() < PlayStage.mapWidth-1 && g.getPosArrayX() > 0)
                        if (PlayStage.mapActors[g.getPosArrayX() + i][g.getPosArrayY() + j] instanceof woodActor)
                            bWoodCutter = true;
                }
            }
            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++) {
                    if (!(g.getPosArrayX() + i > PlayStage.mapWidth - 1 || g.getPosArrayX() + i < 0 ||
                            g.getPosArrayY() + j > PlayStage.mapHeight - 1 || g.getPosArrayY() + j < 0)) {
                        if (PlayStage.mapActors[g.getPosArrayX() + i][g.getPosArrayY() + j] instanceof WoodCutter)
                            bWoodCutter = false;

                    }
                }
            }
            if (bWoodCutter) {
                favago.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        int t[] = {1, mapactor.getPosArrayX(), mapactor.getPosArrayY(), 11};
                        //ujepuletFeltolt(t);
                    }
                });
                bWoodCutter = false;
            } else {
                redX = new OneSpriteStaticActor(Assets.manager.get(Assets.REDX));
                redX.setSize(width / 2, width / 2);
                redX.setPosition(favago.getX(), favago.getY());
                //getActorGroup().addActor(redX);
                favago.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                    }
                });
            }

            boolean bStoneWorker = false;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (g.getPosArrayX() + i < PlayStage.mapWidth && g.getPosArrayX() + i > 0 && g.getPosArrayY() + j < PlayStage.mapHeight && g.getPosArrayY() + j > 0)
                        //if(g.getPosArrayY() < PlayStage.mapHeight-1 && g.getPosArrayY() > 0 && g.getPosArrayX() < PlayStage.mapWidth-1 && g.getPosArrayX() > 0)
                        if (PlayStage.mapActors[g.getPosArrayX() + i][g.getPosArrayY() + j] instanceof stoneActor)
                            bStoneWorker = true;
                }
            }
            for (int i = -2; i <= 2; i++) {
                for (int j = -2; j <= 2; j++) {
                    if (!(g.getPosArrayX() + i > PlayStage.mapWidth - 1 || g.getPosArrayX() + i < 0 ||
                            g.getPosArrayY() + j > PlayStage.mapHeight - 1 || g.getPosArrayY() + j < 0)) {
                        if (PlayStage.mapActors[g.getPosArrayX() + i][g.getPosArrayY() + j] instanceof StoneWorker)
                            bStoneWorker = false;
                    }
                }
            }
            if (bStoneWorker) {
                banya.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        int t[] = {1, mapactor.getPosArrayX(), mapactor.getPosArrayY(), 16};
                        //ujepuletFeltolt(t);
                    }
                });
                bStoneWorker = false;
            } else {
                redX = new OneSpriteStaticActor(Assets.manager.get(Assets.REDX));
                redX.setSize(width / 2, width / 2);
                redX.setPosition(banya.getX(), banya.getY());
                //getActorGroup().addActor(redX);
                banya.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                    }
                });
            }

            haz.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    int t[] = {1, mapactor.getPosArrayX(), mapactor.getPosArrayY(), 14};
                    //ujepuletFeltolt(t);
                }
            });
            barrak.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    int t[] = {1, mapactor.getPosArrayX(), mapactor.getPosArrayY(), 15};
                    //ujepuletFeltolt(t);
                }
            });
            kut.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    int t[] = {1, mapactor.getPosArrayX(), mapactor.getPosArrayY(), 17};
                    //ujepuletFeltolt(t);
                }
            });
            if (mapactor.getPosArrayX() < (PlayStage.mapWidth - 1) && mapactor.getPosArrayX() > 0 && mapactor.getPosArrayY() < (PlayStage.mapHeight - 1) && mapactor.getPosArrayY() > 0 &&
                    PlayStage.mapActors[mapactor.getPosArrayX() + 1][mapactor.getPosArrayY()] instanceof grassActor &&
                    PlayStage.mapActors[mapactor.getPosArrayX() + 1][mapactor.getPosArrayY() + 1] instanceof grassActor &&
                    PlayStage.mapActors[mapactor.getPosArrayX() + 1][mapactor.getPosArrayY() - 1] instanceof grassActor &&
                    PlayStage.mapActors[mapactor.getPosArrayX() - 1][mapactor.getPosArrayY()] instanceof grassActor &&
                    PlayStage.mapActors[mapactor.getPosArrayX() - 1][mapactor.getPosArrayY() - 1] instanceof grassActor &&
                    PlayStage.mapActors[mapactor.getPosArrayX()][mapactor.getPosArrayY() + 1] instanceof grassActor &&
                    PlayStage.mapActors[mapactor.getPosArrayX()][mapactor.getPosArrayY() - 1] instanceof grassActor &&
                    PlayStage.mapActors[mapactor.getPosArrayX() - 1][mapactor.getPosArrayY() + 1] instanceof grassActor) {
                mezo.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        int t[] = {1, mapactor.getPosArrayX(), mapactor.getPosArrayY(), 18};
                        //ujepuletFeltolt(t);
                    }
                });
            } else {
                redX = new OneSpriteStaticActor(Assets.manager.get(Assets.REDX));
                redX.setSize(width / 2, width / 2);
                redX.setPosition(mezo.getX(), mezo.getY());
                //getActorGroup().addActor(redX);
                mezo.addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                    }
                });
            }
        } else {
            allRemove();
            fogtext.setVisible(true);
        }*/

    }


        /*if (aranyLabel == null) {
            //haz
            alapAnyagok(getViewport().getWorldHeight() / 2 + favago.getHeight() + banya.getHeight(), "5", "0", "3", "6", "2");
            getActorGroup().addActor(aranySprite);
            getActorGroup().addActor(koSprite);
            getActorGroup().addActor(faSprite);
            getActorGroup().addActor(husSprite);
            getActorGroup().addActor(emberSprite);

            getActorGroup().addActor(aranyLabel);
            getActorGroup().addActor(koLabel);
            getActorGroup().addActor(faLabel);
            getActorGroup().addActor(husLabel);
            getActorGroup().addActor(emberLabel);

            //banya
            alapAnyagok(getViewport().getWorldHeight() / 2 + favago.getHeight(), "4", "0", "5", "0", "2");
            getActorGroup().addActor(aranySprite);
            getActorGroup().addActor(koSprite);
            getActorGroup().addActor(faSprite);
            getActorGroup().addActor(husSprite);
            getActorGroup().addActor(emberSprite);

            getActorGroup().addActor(aranyLabel);
            getActorGroup().addActor(koLabel);
            getActorGroup().addActor(faLabel);
            getActorGroup().addActor(husLabel);
            getActorGroup().addActor(emberLabel);

            //fakitermelő
            alapAnyagok(getViewport().getWorldHeight() / 2, "2", "0", "0", "0", "2");
            getActorGroup().addActor(aranySprite);
            getActorGroup().addActor(koSprite);
            getActorGroup().addActor(faSprite);
            getActorGroup().addActor(husSprite);
            getActorGroup().addActor(emberSprite);

            getActorGroup().addActor(aranyLabel);
            getActorGroup().addActor(koLabel);
            getActorGroup().addActor(faLabel);
            getActorGroup().addActor(husLabel);
            getActorGroup().addActor(emberLabel);

            //kaszárnya
            alapAnyagok(getViewport().getWorldHeight() / 2 - barrak.getHeight(), "15", "15", "15", "15", "10");
            getActorGroup().addActor(aranySprite);
            getActorGroup().addActor(koSprite);
            getActorGroup().addActor(faSprite);
            getActorGroup().addActor(husSprite);
            getActorGroup().addActor(emberSprite);

            getActorGroup().addActor(aranyLabel);
            getActorGroup().addActor(koLabel);
            getActorGroup().addActor(faLabel);
            getActorGroup().addActor(husLabel);
            getActorGroup().addActor(emberLabel);

            //malom
            alapAnyagok(getViewport().getWorldHeight() / 2 - barrak.getHeight() - mezo.getHeight(), "5", "0", "5", "0", "10");
            getActorGroup().addActor(aranySprite);
            getActorGroup().addActor(koSprite);
            getActorGroup().addActor(faSprite);
            getActorGroup().addActor(husSprite);
            getActorGroup().addActor(emberSprite);

            getActorGroup().addActor(aranyLabel);
            getActorGroup().addActor(koLabel);
            getActorGroup().addActor(faLabel);
            getActorGroup().addActor(husLabel);
            getActorGroup().addActor(emberLabel);

            //kut
            alapAnyagok(getViewport().getWorldHeight() / 2 - barrak.getHeight() - mezo.getHeight() - kut.getHeight() + meret / 10, "5", "0", "5", "0", "0");
            getActorGroup().addActor(aranySprite);
            getActorGroup().addActor(koSprite);
            getActorGroup().addActor(faSprite);
            getActorGroup().addActor(husSprite);
            getActorGroup().addActor(emberSprite);

            getActorGroup().addActor(aranyLabel);
            getActorGroup().addActor(koLabel);
            getActorGroup().addActor(faLabel);
            getActorGroup().addActor(husLabel);
            getActorGroup().addActor(emberLabel);

            emberLabel.setVisible(false);
            System.out.println("valami");
        }*/




    /*private void alapAnyagok(float yPos, String aranyl, String kol, String fal, String husl, String emberl) {
        aranySprite = new OneSpriteStaticActor(Assets.manager.get(Assets.ARANY));
        aranySprite.setSize(meretek, meretek);
        aranySprite.setPosition(meret / 2, yPos);

        koSprite = new OneSpriteStaticActor(Assets.manager.get(Assets.STONE));
        koSprite.setSize(meretek, meretek);
        koSprite.setPosition(meret / 2, yPos + aranySprite.getHeight());

        faSprite = new OneSpriteStaticActor(Assets.manager.get(Assets.WOOD));
        faSprite.setSize(meretek, meretek);
        faSprite.setPosition(meret / 2, yPos + koSprite.getHeight() + aranySprite.getHeight());

        husSprite = new OneSpriteStaticActor(Assets.manager.get(Assets.MEAT));
        husSprite.setSize(meretek, meretek);
        husSprite.setPosition(meret / 2 + meret / 4, yPos + koSprite.getHeight() + aranySprite.getHeight());

        emberSprite = new OneSpriteStaticActor(Assets.manager.get(Assets.PEOPLE));
        emberSprite.setSize(meretek, meretek);
        emberSprite.setPosition(meret / 2 + meret / 4, yPos + koSprite.getHeight());

        aranyLabel = new MyLabel(aranyl, labelStyle(25));
        koLabel = new MyLabel(kol, labelStyle(25));
        faLabel = new MyLabel(fal, labelStyle(25));
        husLabel = new MyLabel(husl, labelStyle(25));
        emberLabel = new MyLabel(emberl, labelStyle(25));

        aranyLabel.setPosition(meret / 2 + aranySprite.getWidth(), yPos);
        koLabel.setPosition(meret / 2 + koSprite.getWidth(), yPos + aranySprite.getHeight());
        faLabel.setPosition(meret / 2 + faSprite.getWidth(), yPos + aranySprite.getHeight() + koSprite.getHeight());

        emberLabel.setPosition(meret / 2 + meret / 4 + emberSprite.getWidth(), yPos + koSprite.getHeight());
        husLabel.setPosition(meret / 2 + meret / 4 + husSprite.getWidth(), yPos + koSprite.getHeight() + emberLabel.getHeight());

    }*/

}
