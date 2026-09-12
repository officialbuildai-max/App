package com.transsion.postdetail.layer.listener;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b5\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5¨\u00066"}, d2 = {"Lcom/transsion/postdetail/layer/listener/LayerFlag;", "", "<init>", "(Ljava/lang/String;I)V", "INIT_PLAY", "RENDER_FIRST_FRAME", "COMPLETION", "VIDEO_PAUSE", "VIDEO_START", "PLAY_ERROR", "VIDEO_SIZE_CHANGED", "LOADING_BEGIN", "PROGRESS", "LOADING_END", "PLAYER_RESET", "INIT_VIEW", "INIT_VIEW_TYPE", "INIT_DATA", "ADD_SURFACE", "SCREEN_ORIENTATION_CHANGED", "LOCAL_UI_CHANGED", "LAYER_EVENT", "SET_PARAMS", "UPDATE_DATA", "UPDATE_DOWNLOAD_DATA", "UPDATE_TITLE", "SET_PLAYER", "SET_MANAGER", "BACK_PRESSED", "LOOPING_START", "BOTTOM_CONTROL", "SUBTITLE_CONTROL", "DOWNLOAD_PROGRESS", "DOWNLOAD_SPEED", "DOWNLOAD_CALLBACK", "SHOW_TOAST", "REMOVE_TOAST", "NETWORK_CHANGE", "PLAYER_TIMEOUT_TIPS", "REQUEST_FORYOU", "SERIES_INIT", "SERIES_EVENT", "SERIES_PLAY", "SERIES_LOCAL2NET", "UPDATE_SPEED", "UPDATE_ROTATION", "RELEASE_PLAYER", "SHOW_FLOAT_2_WINDOW", "INTO_PIP", "PLAYER_FOREGROUND", "FRAGMENT_PAUSE", "FRAGMENT_STOP", "FRAGMENT_RESUME", "FRAGMENT_DESTROY", "PostDetail_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes6.dex */
public final class LayerFlag {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LayerFlag[] $VALUES;
    public static final LayerFlag INIT_PLAY = new LayerFlag("INIT_PLAY", 0);
    public static final LayerFlag RENDER_FIRST_FRAME = new LayerFlag("RENDER_FIRST_FRAME", 1);
    public static final LayerFlag COMPLETION = new LayerFlag("COMPLETION", 2);
    public static final LayerFlag VIDEO_PAUSE = new LayerFlag("VIDEO_PAUSE", 3);
    public static final LayerFlag VIDEO_START = new LayerFlag("VIDEO_START", 4);
    public static final LayerFlag PLAY_ERROR = new LayerFlag("PLAY_ERROR", 5);
    public static final LayerFlag VIDEO_SIZE_CHANGED = new LayerFlag("VIDEO_SIZE_CHANGED", 6);
    public static final LayerFlag LOADING_BEGIN = new LayerFlag("LOADING_BEGIN", 7);
    public static final LayerFlag PROGRESS = new LayerFlag("PROGRESS", 8);
    public static final LayerFlag LOADING_END = new LayerFlag("LOADING_END", 9);
    public static final LayerFlag PLAYER_RESET = new LayerFlag("PLAYER_RESET", 10);
    public static final LayerFlag INIT_VIEW = new LayerFlag("INIT_VIEW", 11);
    public static final LayerFlag INIT_VIEW_TYPE = new LayerFlag("INIT_VIEW_TYPE", 12);
    public static final LayerFlag INIT_DATA = new LayerFlag("INIT_DATA", 13);
    public static final LayerFlag ADD_SURFACE = new LayerFlag("ADD_SURFACE", 14);
    public static final LayerFlag SCREEN_ORIENTATION_CHANGED = new LayerFlag("SCREEN_ORIENTATION_CHANGED", 15);
    public static final LayerFlag LOCAL_UI_CHANGED = new LayerFlag("LOCAL_UI_CHANGED", 16);
    public static final LayerFlag LAYER_EVENT = new LayerFlag("LAYER_EVENT", 17);
    public static final LayerFlag SET_PARAMS = new LayerFlag("SET_PARAMS", 18);
    public static final LayerFlag UPDATE_DATA = new LayerFlag("UPDATE_DATA", 19);
    public static final LayerFlag UPDATE_DOWNLOAD_DATA = new LayerFlag("UPDATE_DOWNLOAD_DATA", 20);
    public static final LayerFlag UPDATE_TITLE = new LayerFlag("UPDATE_TITLE", 21);
    public static final LayerFlag SET_PLAYER = new LayerFlag("SET_PLAYER", 22);
    public static final LayerFlag SET_MANAGER = new LayerFlag("SET_MANAGER", 23);
    public static final LayerFlag BACK_PRESSED = new LayerFlag("BACK_PRESSED", 24);
    public static final LayerFlag LOOPING_START = new LayerFlag("LOOPING_START", 25);
    public static final LayerFlag BOTTOM_CONTROL = new LayerFlag("BOTTOM_CONTROL", 26);
    public static final LayerFlag SUBTITLE_CONTROL = new LayerFlag("SUBTITLE_CONTROL", 27);
    public static final LayerFlag DOWNLOAD_PROGRESS = new LayerFlag("DOWNLOAD_PROGRESS", 28);
    public static final LayerFlag DOWNLOAD_SPEED = new LayerFlag("DOWNLOAD_SPEED", 29);
    public static final LayerFlag DOWNLOAD_CALLBACK = new LayerFlag("DOWNLOAD_CALLBACK", 30);
    public static final LayerFlag SHOW_TOAST = new LayerFlag("SHOW_TOAST", 31);
    public static final LayerFlag REMOVE_TOAST = new LayerFlag("REMOVE_TOAST", 32);
    public static final LayerFlag NETWORK_CHANGE = new LayerFlag("NETWORK_CHANGE", 33);
    public static final LayerFlag PLAYER_TIMEOUT_TIPS = new LayerFlag("PLAYER_TIMEOUT_TIPS", 34);
    public static final LayerFlag REQUEST_FORYOU = new LayerFlag("REQUEST_FORYOU", 35);
    public static final LayerFlag SERIES_INIT = new LayerFlag("SERIES_INIT", 36);
    public static final LayerFlag SERIES_EVENT = new LayerFlag("SERIES_EVENT", 37);
    public static final LayerFlag SERIES_PLAY = new LayerFlag("SERIES_PLAY", 38);
    public static final LayerFlag SERIES_LOCAL2NET = new LayerFlag("SERIES_LOCAL2NET", 39);
    public static final LayerFlag UPDATE_SPEED = new LayerFlag("UPDATE_SPEED", 40);
    public static final LayerFlag UPDATE_ROTATION = new LayerFlag("UPDATE_ROTATION", 41);
    public static final LayerFlag RELEASE_PLAYER = new LayerFlag("RELEASE_PLAYER", 42);
    public static final LayerFlag SHOW_FLOAT_2_WINDOW = new LayerFlag("SHOW_FLOAT_2_WINDOW", 43);
    public static final LayerFlag INTO_PIP = new LayerFlag("INTO_PIP", 44);
    public static final LayerFlag PLAYER_FOREGROUND = new LayerFlag("PLAYER_FOREGROUND", 45);
    public static final LayerFlag FRAGMENT_PAUSE = new LayerFlag("FRAGMENT_PAUSE", 46);
    public static final LayerFlag FRAGMENT_STOP = new LayerFlag("FRAGMENT_STOP", 47);
    public static final LayerFlag FRAGMENT_RESUME = new LayerFlag("FRAGMENT_RESUME", 48);
    public static final LayerFlag FRAGMENT_DESTROY = new LayerFlag("FRAGMENT_DESTROY", 49);

    private static final /* synthetic */ LayerFlag[] $values() {
        return new LayerFlag[]{INIT_PLAY, RENDER_FIRST_FRAME, COMPLETION, VIDEO_PAUSE, VIDEO_START, PLAY_ERROR, VIDEO_SIZE_CHANGED, LOADING_BEGIN, PROGRESS, LOADING_END, PLAYER_RESET, INIT_VIEW, INIT_VIEW_TYPE, INIT_DATA, ADD_SURFACE, SCREEN_ORIENTATION_CHANGED, LOCAL_UI_CHANGED, LAYER_EVENT, SET_PARAMS, UPDATE_DATA, UPDATE_DOWNLOAD_DATA, UPDATE_TITLE, SET_PLAYER, SET_MANAGER, BACK_PRESSED, LOOPING_START, BOTTOM_CONTROL, SUBTITLE_CONTROL, DOWNLOAD_PROGRESS, DOWNLOAD_SPEED, DOWNLOAD_CALLBACK, SHOW_TOAST, REMOVE_TOAST, NETWORK_CHANGE, PLAYER_TIMEOUT_TIPS, REQUEST_FORYOU, SERIES_INIT, SERIES_EVENT, SERIES_PLAY, SERIES_LOCAL2NET, UPDATE_SPEED, UPDATE_ROTATION, RELEASE_PLAYER, SHOW_FLOAT_2_WINDOW, INTO_PIP, PLAYER_FOREGROUND, FRAGMENT_PAUSE, FRAGMENT_STOP, FRAGMENT_RESUME, FRAGMENT_DESTROY};
    }

    static {
        LayerFlag[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.a($values);
    }

    private LayerFlag(String str, int i11) {
    }

    public static EnumEntries<LayerFlag> getEntries() {
        return $ENTRIES;
    }

    public static LayerFlag valueOf(String str) {
        return (LayerFlag) Enum.valueOf(LayerFlag.class, str);
    }

    public static LayerFlag[] values() {
        return (LayerFlag[]) $VALUES.clone();
    }
}
