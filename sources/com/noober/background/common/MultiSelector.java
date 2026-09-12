package com.noober.background.common;

import android.R;

/* loaded from: classes5.dex */
public enum MultiSelector {
    State_Checkable("state_checkable", R.attr.state_checkable),
    State_Checked("state_checked", R.attr.state_checked),
    State_Enabled("state_enabled", R.attr.state_enabled),
    State_Selected("state_selected", R.attr.state_selected),
    State_Pressed("state_pressed", R.attr.state_pressed),
    State_Focused("state_focused", R.attr.state_focused),
    State_Hovered("state_hovered", R.attr.state_hovered),
    State_Activated("state_activated", R.attr.state_activated);


    /* renamed from: id, reason: collision with root package name */
    public int f40115id;
    public String value;

    MultiSelector(String str, int i11) {
        this.value = str;
        this.f40115id = i11;
    }

    public static MultiSelector getMultiAttr(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1722420599:
                if (str.equals("state_selected")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1616325175:
                if (str.equals("state_focused")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1243548044:
                if (str.equals("state_pressed")) {
                    c11 = 2;
                    break;
                }
                break;
            case -182969863:
                if (str.equals("state_checked")) {
                    c11 = 3;
                    break;
                }
                break;
            case 64931747:
                if (str.equals("state_activated")) {
                    c11 = 4;
                    break;
                }
                break;
            case 175751469:
                if (str.equals("state_hovered")) {
                    c11 = 5;
                    break;
                }
                break;
            case 259503156:
                if (str.equals("state_checkable")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1760089491:
                if (str.equals("state_enabled")) {
                    c11 = 7;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return State_Selected;
            case 1:
                return State_Focused;
            case 2:
                return State_Pressed;
            case 3:
                return State_Checked;
            case 4:
                return State_Activated;
            case 5:
                return State_Hovered;
            case 6:
                return State_Checkable;
            case 7:
                return State_Enabled;
            default:
                return null;
        }
    }
}
