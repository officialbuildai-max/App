package com.transsion.member;

import com.transsion.memberapi.MemberRemindData;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public static final a1 f46462a = new a1();

    private a1() {
    }

    public final boolean a(MemberRemindData memberRemindData, int i11) {
        String type;
        String remindUnit;
        String remindUnit2;
        if (memberRemindData == null || (type = memberRemindData.getType()) == null || type.length() == 0 || memberRemindData.getRemindValue() == null || (remindUnit = memberRemindData.getRemindUnit()) == null || remindUnit.length() == 0 || Intrinsics.c(memberRemindData.getType(), "REMIND_TYPE_UNSPECIFIED") || Intrinsics.c(memberRemindData.getRemindUnit(), "REMIND_UNIT_UNSPECIFIED") || (remindUnit2 = memberRemindData.getRemindUnit()) == null) {
            return false;
        }
        switch (remindUnit2.hashCode()) {
            case -2084621051:
                if (!remindUnit2.equals("REMIND_UNIT_HOUR")) {
                    return false;
                }
                int i12 = i11 * 24;
                Integer remindValue = memberRemindData.getRemindValue();
                Intrinsics.e(remindValue);
                return i12 <= remindValue.intValue();
            case -1728668427:
                if (!remindUnit2.equals("REMIND_UNIT_MINUTE")) {
                    return false;
                }
                int i13 = i11 * 1440;
                Integer remindValue2 = memberRemindData.getRemindValue();
                Intrinsics.e(remindValue2);
                return i13 <= remindValue2.intValue();
            case -194132129:
                if (!remindUnit2.equals("REMIND_UNIT_MONTH")) {
                    return false;
                }
                Integer remindValue3 = memberRemindData.getRemindValue();
                Intrinsics.e(remindValue3);
                return i11 <= remindValue3.intValue() * 30;
            case -67250117:
                if (!remindUnit2.equals("REMIND_UNIT_DAY")) {
                    return false;
                }
                Integer remindValue4 = memberRemindData.getRemindValue();
                Intrinsics.e(remindValue4);
                return i11 <= remindValue4.intValue();
            default:
                return false;
        }
    }
}
