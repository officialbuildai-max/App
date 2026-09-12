package com.transsion.athena.data;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class Track {
    public static final int SAVE_FLAG_NONE = -1;
    public static final int SAVE_FLAG_TO_DB = 1;
    public static final int SAVE_FLAG_TO_FILE = 0;

    /* renamed from: a, reason: collision with root package name */
    private String f42702a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f42703b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f42704c;

    /* renamed from: d, reason: collision with root package name */
    private long f42705d;

    /* renamed from: e, reason: collision with root package name */
    private int f42706e;

    /* renamed from: f, reason: collision with root package name */
    private long f42707f;

    /* renamed from: g, reason: collision with root package name */
    private long f42708g;

    /* renamed from: h, reason: collision with root package name */
    private String f42709h;

    /* renamed from: i, reason: collision with root package name */
    private TrackData f42710i;

    public String getBootId() {
        return this.f42709h;
    }

    public String getEventName() {
        return this.f42702a;
    }

    public JSONObject getJsonData() {
        return this.f42703b;
    }

    public JSONObject getOriginJsonData() {
        return this.f42704c;
    }

    public long getTid() {
        return this.f42705d;
    }

    public TrackData getTrackData() {
        return this.f42710i;
    }

    public long getTrackErTs() {
        return this.f42708g;
    }

    public int getTrackFlag() {
        return this.f42706e;
    }

    public long getTrackTs() {
        return this.f42707f;
    }

    public void setBootId(String str) {
        this.f42709h = str;
    }

    public void setEventName(String str) {
        this.f42702a = str;
    }

    public void setJsonData(JSONObject jSONObject) {
        this.f42703b = jSONObject;
    }

    public void setOriginJsonData(JSONObject jSONObject) {
        this.f42704c = jSONObject;
    }

    public void setTid(long j11) {
        this.f42705d = j11;
    }

    public void setTrackData(TrackData trackData) {
        this.f42710i = trackData;
    }

    public void setTrackErTs(long j11) {
        this.f42708g = j11;
    }

    public void setTrackFlag(int i11) {
        this.f42706e = i11;
    }

    public void setTrackTs(long j11) {
        this.f42707f = j11;
    }

    @NonNull
    public String toString() {
        return "tid = " + this.f42705d + ",event = " + this.f42703b.toString();
    }
}
