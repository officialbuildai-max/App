package com.hisavana.mediation.config;

import android.text.TextUtils;
import android.util.Log;
import be.e;
import be.f;
import be.g;
import be.j;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.hisavana.common.bean.Network;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.common.utils.MediaLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ConfigContentHelper {

    /* renamed from: a, reason: collision with root package name */
    public final j f33288a;

    /* renamed from: b, reason: collision with root package name */
    public final g f33289b;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final ConfigContentHelper f33290a = new ConfigContentHelper();
    }

    public ConfigContentHelper() {
        this.f33289b = g.d();
        if (TextUtils.equals(TAdManager.getAhaChannel(), ComConstants.AHA_CHANNEL)) {
            this.f33288a = f.d();
        } else {
            this.f33288a = e.d();
        }
    }

    public static ConfigContentHelper g() {
        return a.f33290a;
    }

    public void b() {
        this.f33289b.b();
    }

    public void c() {
        this.f33289b.b();
        this.f33288a.a();
    }

    public List d() {
        return this.f33288a.c();
    }

    public CloudControlConfig.CodeSeat e(String str) {
        if (TextUtils.isEmpty(str)) {
            MediaLogUtil.e("ConfigContentHelper", "getConfig,codeSeatId is empty");
            AdLogUtil.Log().e("ConfigContentHelper", "getConfig,codeSeatId is empty");
            return null;
        }
        MediaLogUtil.d("ConfigContentHelper", "getConfig " + str);
        try {
            CloudControlConfig.CodeSeat a11 = this.f33289b.a(str);
            if (a11 == null) {
                HSScopeHelper.f23249a.g(new Runnable() { // from class: com.hisavana.mediation.config.ConfigContentHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ConfigContentHelper.this.h();
                    }
                });
            }
            if (a11 != null || !TextUtils.equals(TAdManager.getAhaChannel(), ComConstants.AHA_CHANNEL)) {
                return a11;
            }
            Network network = new Network();
            CloudControlConfig.CodeSeat codeSeat = new CloudControlConfig.CodeSeat();
            ArrayList arrayList = new ArrayList();
            codeSeat.setNetworks(arrayList);
            arrayList.add(network);
            codeSeat.setCodeSeatId(str);
            network.setCodeSeatId(str);
            network.setPrice(Double.valueOf(0.0d));
            network.setSource(1);
            AdLogUtil.Log().d("ConfigContentHelper", "aha channel return default config");
            return codeSeat;
        } catch (Exception e11) {
            AdLogUtil.Log().e("ConfigContentHelper", "ex " + Log.getStackTraceString(e11));
            MediaLogUtil.d("ConfigContentHelper", "getConfig,codeSeatId " + str + ",codeSeat is null");
            return null;
        }
    }

    public long f() {
        return this.f33288a.b();
    }

    public void h() {
        AdLogUtil.Log().d("ConfigContentHelper", "getConfig from database");
        this.f33289b.c(this.f33288a.c());
    }

    public boolean i(List list) {
        AdLogUtil.Log().d("ConfigContentHelper", "insert ");
        List<CloudControlConfig.CodeSeat> d11 = d();
        if (d11 != null && !d11.isEmpty()) {
            for (CloudControlConfig.CodeSeat codeSeat : d11) {
                if (codeSeat != null) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CloudControlConfig.CodeSeat codeSeat2 = (CloudControlConfig.CodeSeat) it.next();
                        if (codeSeat2 != null && TextUtils.equals(codeSeat.getCodeSeatId(), codeSeat2.getCodeSeatId())) {
                            codeSeat2.setCurrentHourZeroClock(codeSeat.getCurrentHourZeroClock());
                            codeSeat2.setLastShowTime(codeSeat.getLastShowTime());
                            codeSeat2.setCurrentHourShowTimes(codeSeat.getCurrentHourShowTimes());
                            codeSeat2.setTodayZeroClock(codeSeat.getTodayZeroClock());
                            codeSeat2.setTodayShowTimes(codeSeat.getTodayShowTimes());
                            break;
                        }
                    }
                }
            }
        }
        this.f33289b.c(list);
        return this.f33288a.a(list);
    }

    public void j(final CloudControlConfig.CodeSeat codeSeat) {
        AdLogUtil.Log().d("ConfigContentHelper", "updateConfig " + codeSeat);
        HSScopeHelper.f23249a.g(new Runnable() { // from class: com.hisavana.mediation.config.ConfigContentHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (ConfigContentHelper.this.f33288a != null) {
                    ConfigContentHelper.this.f33288a.a(codeSeat);
                }
            }
        });
    }
}
