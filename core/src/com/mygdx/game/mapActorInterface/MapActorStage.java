package com.mygdx.game.mapActorInterface;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.mygdx.game.GlobalClasses.Assets;
import com.mygdx.game.MyBaseClasses.MyLabel;
import com.mygdx.game.MyBaseClasses.MyStage;
import com.mygdx.game.MyBaseClasses.OneSpriteStaticActor;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Play.mapActor;

/**
 * Created by tuskeb on 2017. 01. 26..
 */

public class MapActorStage extends MyStage {

    mapActor mapactor;
    OneSpriteStaticActor selectActor; //kijelölő négyzet
    private static OneSpriteStaticActor hatter; //fa háttér

    private static boolean elsoinditas = true;

    protected final float width = 256; // szélesség
    protected final float height = getViewport().getWorldHeight(); // magasság
    private float meretek = (width / 2) / 4; // ikonok mérete

    //legyen minden static már úgysem lehet jobban elrontani :D
    protected static OneSpriteStaticActor banya, barrak, favago, halasz, haz, kut, mezo, hid;

    protected static OneSpriteStaticActor redX, faSprite, koSprite, aranySprite, emberSprite, husSprite, /*földes képek*/
            vizfaSprite, vizkoSprite, vizaranySprite, vizemberSprite, vizhusSprite; //vizes képek

    protected static MyLabel faLabel, koLabel, aranyLabel, emberLabel, husLabel, /*füves labelek*/
            vizfaLabel, vizkoLabel, vizaranyLabel, vizemberLabel, vizhusLabel; //vizes labelek

    protected static OneSpriteStaticActor barrackIcon, bridgeIcon, cityIcon, fishdockIcon, ashIcon, houseIcon, millfieldIcon,
            millIcon, stoneIcon, stoneworkerIcon, waterwellIcon, woodIcon, woodcutterIcon;
    //épületek, ikonok és labelek vége

    protected static MyLabel fogtext;
    public static float meretes = 100;

    public MapActorStage(MyGdxGame game, mapActor ma) {
        super(new ExtendViewport(1280, 720, new OrthographicCamera(1280, 720)), new SpriteBatch(), game);
        if (ma != null) {
            mapactor = ma;
            mapactor.setVisible(true);
            addSelectActor(ma.getStage());
        }

        if (elsoinditas) {
            elsoinditas = false;
            fakeInit();
        }
    }

    private void fakeInit(){
        hatter = new OneSpriteStaticActor(Assets.manager.get(Assets.FAHATTER)) {
            @Override
            public void init() {
                super.init();
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                    }
                });
            }
        };
        hatter.setPosition(getViewport().getWorldWidth() - width, 0);
        hatter.setSize(width, height);
        addActor(hatter);


        fogtext = new MyLabel("You can't\nbuild here!\n\nYou haven't\nexplored\nthis side of\n the map yet!", labelStyle(50));
        fogtext.setAlignment(Align.center);
        fogtext.setPosition((getViewport().getWorldWidth() - width) / 2 - fogtext.getWidth() / 2, getViewport().getWorldHeight() / 2 - fogtext.getHeight() / 2);
        addActor(fogtext);
        fogtext.setVisible(false);

        customStages();
        buildings();
        icons();
    }

    @Override
    public void init() {
        System.out.println("+sdasda");
        for (Actor a:getActors()) {
            a.setVisible(true);
        }
    }

    private void customStages() {
        barrackIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.BARRACK));
        barrackIcon.setSize(width / 2, width / 2);
        barrackIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        barrackIcon.setVisible(false);
        addActor(barrackIcon);

        bridgeIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.BRIDGE));
        bridgeIcon.setSize(width / 2, width / 2);
        bridgeIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        bridgeIcon.setVisible(false);
        addActor(bridgeIcon);

        cityIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.CITY_HALL));
        cityIcon.setSize(width / 2, width / 2);
        cityIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        cityIcon.setVisible(false);
        addActor(cityIcon);

        fishdockIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.FISHDOCK));
        fishdockIcon.setSize(width / 2, width / 2);
        fishdockIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        fishdockIcon.setVisible(false);
        addActor(fishdockIcon);

        ashIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.HAMU));
        ashIcon.setSize(width / 2, width / 2);
        ashIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        ashIcon.setVisible(false);
        addActor(ashIcon);

        houseIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.HOUSE));
        houseIcon.setSize(width / 2, width / 2);
        houseIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        houseIcon.setVisible(false);
        addActor(houseIcon);

        millfieldIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.MILLMEZO));
        millfieldIcon.setSize(width / 2, width / 2);
        millfieldIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        millfieldIcon.setVisible(false);
        addActor(millfieldIcon);

        millIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.MILL));
        millIcon.setSize(width / 2, width / 2);
        millIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        millIcon.setVisible(false);
        addActor(millIcon);

        stoneIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.STONE));
        stoneIcon.setSize(width / 2, width / 2);
        stoneIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        stoneIcon.setVisible(false);
        addActor(stoneIcon);

        stoneworkerIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.STONE_WORKER));
        stoneworkerIcon.setSize(width / 2, width / 2);
        stoneworkerIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        stoneworkerIcon.setVisible(false);
        addActor(stoneworkerIcon);

        waterwellIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.WATER_WELL));
        waterwellIcon.setSize(width / 2, width / 2);
        waterwellIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        waterwellIcon.setVisible(false);
        addActor(waterwellIcon);

        woodcutterIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.WOOD_WORKER));
        woodcutterIcon.setSize(width / 2, width / 2);
        woodcutterIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        woodcutterIcon.setVisible(false);
        addActor(woodcutterIcon);

        woodIcon = new OneSpriteStaticActor(Assets.manager.get(Assets.TREE_BLOCK));
        woodIcon.setSize(width / 2, width / 2);
        woodIcon.setPosition(getViewport().getWorldWidth() - width + width / 4, getViewport().getWorldHeight() - width);
        woodIcon.setVisible(false);
        addActor(woodIcon);
    }

    protected void grassBuildings() {
        //hatter.setVisible(true);
        favago.setVisible(true);
        banya.setVisible(true);
        mezo.setVisible(true);
        kut.setVisible(true);
        barrak.setVisible(true);
        haz.setVisible(true);
    }

    protected void waterBuildings() {
        //hatter.setVisible(true);
        halasz.setVisible(true);
        hid.setVisible(true);
    }

    private void icons() {
        //földi épületek
        alapAnyagok(height / 2 + favago.getHeight() + banya.getHeight(), "5", "0", "3", "6", "2");
        alapAnyagok(height / 2 + favago.getHeight(), "4", "0", "5", "0", "2");
        alapAnyagok(height / 2, "2", "0", "0", "0", "2");
        alapAnyagok(height / 2 - barrak.getHeight(), "15", "15", "15", "15", "10");
        alapAnyagok(height / 2 - barrak.getHeight() - mezo.getHeight(), "5", "0", "5", "0", "10");
        alapAnyagok(height / 2 - barrak.getHeight() - mezo.getHeight() - kut.getHeight(), "5", "0", "5", "0", "0");

        //vízi épületek
        alapAnyagokViz(getViewport().getWorldHeight() / 2, "2", "0", "1", "0", "1");
        alapAnyagokViz(getViewport().getWorldHeight() / 2 - hid.getHeight(), "10", "50", "0", "0", "0");
    }

    protected void allRemove() {
        /*for (Actor a : getActors()) {
            a.setVisible(false);
        }*/
        hatter.setVisible(true);
    }

    private void alapAnyagokViz(float yPos, String aranyl, String kol, String fal, String husl, String emberl) {
        vizaranySprite = new OneSpriteStaticActor(Assets.manager.get(Assets.ARANY));
        vizaranySprite.setSize(meretek, meretek);
        vizaranySprite.setPosition(getViewport().getWorldWidth() - width / 2, yPos);

        vizkoSprite = new OneSpriteStaticActor(Assets.manager.get(Assets.STONE));
        vizkoSprite.setSize(meretek, meretek);
        vizkoSprite.setPosition(getViewport().getWorldWidth() - width / 2, yPos + aranySprite.getHeight());

        vizfaSprite = new OneSpriteStaticActor(Assets.manager.get(Assets.WOOD));
        vizfaSprite.setSize(meretek, meretek);
        vizfaSprite.setPosition(getViewport().getWorldWidth() - width / 2, yPos + koSprite.getHeight() + aranySprite.getHeight());

        vizhusSprite = new OneSpriteStaticActor(Assets.manager.get(Assets.MEAT));
        vizhusSprite.setSize(meretek, meretek);
        vizhusSprite.setPosition(getViewport().getWorldWidth() - width / 2 + width / 4, yPos + koSprite.getHeight() + aranySprite.getHeight());

        vizemberSprite = new OneSpriteStaticActor(Assets.manager.get(Assets.PEOPLE));
        vizemberSprite.setSize(meretek, meretek);
        vizemberSprite.setPosition(getViewport().getWorldWidth() - width / 2 + width / 4, yPos + koSprite.getHeight());

        vizaranyLabel = new MyLabel(aranyl, labelStyle(25));
        vizkoLabel = new MyLabel(kol, labelStyle(25));
        vizfaLabel = new MyLabel(fal, labelStyle(25));
        vizhusLabel = new MyLabel(husl, labelStyle(25));
        vizemberLabel = new MyLabel(emberl, labelStyle(25));

        vizaranyLabel.setPosition(getViewport().getWorldWidth() - width / 2 + aranySprite.getWidth(), yPos);
        vizkoLabel.setPosition(getViewport().getWorldWidth() - width / 2 + koSprite.getWidth(), yPos + aranySprite.getHeight());
        vizfaLabel.setPosition(getViewport().getWorldWidth() - width / 2 + faSprite.getWidth(), yPos + aranySprite.getHeight() + koSprite.getHeight());

        vizemberLabel.setPosition(getViewport().getWorldWidth() - width / 2 + width / 4 + emberSprite.getWidth(), yPos + koSprite.getHeight());
        vizhusLabel.setPosition(getViewport().getWorldWidth() - width / 2 + width / 4 + husSprite.getWidth(), yPos + koSprite.getHeight() + emberLabel.getHeight());

        addActor(vizaranySprite);
        addActor(vizkoSprite);
        addActor(vizfaSprite);
        addActor(vizhusSprite);
        addActor(vizemberSprite);

        addActor(aranyLabel);
        addActor(koLabel);
        addActor(faLabel);
        addActor(husLabel);
        addActor(emberLabel);

    }

    private void alapAnyagok(float yPos, String aranyl, String kol, String fal, String husl, String emberl) {
        aranySprite = new OneSpriteStaticActor(Assets.manager.get(Assets.ARANY));
        aranySprite.setSize(meretek, meretek);
        aranySprite.setPosition(getViewport().getWorldWidth() - width / 2, yPos);

        koSprite = new OneSpriteStaticActor(Assets.manager.get(Assets.STONE));
        koSprite.setSize(meretek, meretek);
        koSprite.setPosition(getViewport().getWorldWidth() - width / 2, yPos + aranySprite.getHeight());

        faSprite = new OneSpriteStaticActor(Assets.manager.get(Assets.WOOD));
        faSprite.setSize(meretek, meretek);
        faSprite.setPosition(getViewport().getWorldWidth() - width / 2, yPos + koSprite.getHeight() + aranySprite.getHeight());

        husSprite = new OneSpriteStaticActor(Assets.manager.get(Assets.MEAT));
        husSprite.setSize(meretek, meretek);
        husSprite.setPosition(getViewport().getWorldWidth() - width / 2 + width / 4, yPos + koSprite.getHeight() + aranySprite.getHeight());

        emberSprite = new OneSpriteStaticActor(Assets.manager.get(Assets.PEOPLE));
        emberSprite.setSize(meretek, meretek);
        emberSprite.setPosition(getViewport().getWorldWidth() - width / 2 + width / 4, yPos + koSprite.getHeight());

        aranyLabel = new MyLabel(aranyl, labelStyle(25));
        koLabel = new MyLabel(kol, labelStyle(25));
        faLabel = new MyLabel(fal, labelStyle(25));
        husLabel = new MyLabel(husl, labelStyle(25));
        emberLabel = new MyLabel(emberl, labelStyle(25));

        aranyLabel.setPosition(getViewport().getWorldWidth() - width / 2 + aranySprite.getWidth(), yPos);
        koLabel.setPosition(getViewport().getWorldWidth() - width / 2 + koSprite.getWidth(), yPos + aranySprite.getHeight());
        faLabel.setPosition(getViewport().getWorldWidth() - width / 2 + faSprite.getWidth(), yPos + aranySprite.getHeight() + koSprite.getHeight());

        emberLabel.setPosition(getViewport().getWorldWidth() - width / 2 + width / 4 + emberSprite.getWidth(), yPos + koSprite.getHeight());
        husLabel.setPosition(getViewport().getWorldWidth() - width / 2 + width / 4 + husSprite.getWidth(), yPos + koSprite.getHeight() + emberLabel.getHeight());

        addActor(aranySprite);
        addActor(koSprite);
        addActor(faSprite);
        addActor(husSprite);
        addActor(emberSprite);

        addActor(aranyLabel);
        addActor(koLabel);
        addActor(faLabel);
        addActor(husLabel);
        addActor(emberLabel);

    }

    private void buildings() {
        favago = new OneSpriteStaticActor(Assets.manager.get(Assets.FAVAGO)) {
            @Override
            public void init() {
                super.init();
                setSize(width / 2, width / 2);
                setPosition(getViewport().getWorldWidth() - width, height / 2);
            }
        };
        //----------------------------------------
        banya = new OneSpriteStaticActor(Assets.manager.get(Assets.BANYA)) {
            @Override
            public void init() {
                super.init();
                setSize(width / 2, width / 2);
                setPosition(getViewport().getWorldWidth() - width, height / 2 + favago.getHeight());
            }
        };
        //----------------------------------------
        haz = new OneSpriteStaticActor(Assets.manager.get(Assets.HAZ)) {
            @Override
            public void init() {
                super.init();
                setSize(width / 2, width / 2);
                setPosition(getViewport().getWorldWidth() - width, height / 2 + favago.getHeight() + banya.getHeight());
            }
        };
        //----------------------------------------
        barrak = new OneSpriteStaticActor(Assets.manager.get(Assets.BARAKK)) {
            @Override
            public void init() {
                super.init();
                setSize(width / 2, width / 2);
                setPosition(getViewport().getWorldWidth() - width, height / 2 - getHeight());
            }
        };
        //----------------------------------------
        kut = new OneSpriteStaticActor(Assets.manager.get(Assets.KUT)) {
            @Override
            public void init() {
                super.init();
                setSize(width / 2, width / 2);
                setPosition(getViewport().getWorldWidth() - width, height / 2 - barrak.getHeight() - getHeight());
            }
        };
        //----------------------------------------
        mezo = new OneSpriteStaticActor(Assets.manager.get(Assets.MEZO)) {
            @Override
            public void init() {
                super.init();
                setSize(width / 2, width / 2);
                setPosition(getViewport().getWorldWidth() - width, height / 2 - barrak.getHeight() - kut.getHeight() - getHeight());
            }
        };


        //----------------------------------------
        halasz = new OneSpriteStaticActor(Assets.manager.get(Assets.HALASZ)) {
            @Override
            public void init() {
                super.init();
                setSize(width / 2, width / 2);
                setPosition(getViewport().getWorldWidth() - width, height / 2);
            }
        };
        //----------------------------------------
        hid = new OneSpriteStaticActor(Assets.manager.get(Assets.HID)) {
            @Override
            public void init() {
                super.init();
                setSize(width / 2, width / 2);
                setPosition(getViewport().getWorldWidth() - width, height / 2 - getHeight());
            }
        };

        addActor(favago);
        addActor(banya);
        addActor(haz);
        addActor(barrak);
        addActor(kut);
        addActor(mezo);
        addActor(halasz);
        addActor(hid);
    }

    public void addSelectActor(Stage stage) { // kijelölés(sárga)
        if (mapactor != null && !mapactor.isFog()) {
            this.selectActor = new OneSpriteStaticActor(Assets.manager.get(Assets.KIJELOLES)) {
                @Override
                public void init() {
                    super.init();
                    setSize(mapactor.getMapActorWidth(), mapactor.getMapActorHeight());
                    setPosition(mapactor.getX() - (mapactor.getMapActorWidth() - 128), mapactor.getY());
                    setTouchable(Touchable.disabled);
                }
            };
            stage.addActor(selectActor);
        }
    }

    public static Label.LabelStyle labelStyle(int a) {
        Label.LabelStyle style = new Label.LabelStyle();

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Font/acmeregular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter meret = new FreeTypeFontGenerator.FreeTypeFontParameter();
        meret.size = a;
        meret.characters = Assets.CHARS;
        BitmapFont font = generator.generateFont(meret);
        generator.dispose();
        style.font = font;

        return style;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

}
