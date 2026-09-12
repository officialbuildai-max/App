package com.transsion.json;

/* loaded from: classes.dex */
public class n extends Number {

    /* renamed from: a, reason: collision with root package name */
    private final String f46144a;

    /* renamed from: b, reason: collision with root package name */
    final String f46145b = "(\\p{Digit}+)";

    /* renamed from: c, reason: collision with root package name */
    final String f46146c = "(\\p{XDigit}+)";

    /* renamed from: d, reason: collision with root package name */
    final String f46147d = "[eE][+-]?(\\p{Digit}+)";

    /* renamed from: e, reason: collision with root package name */
    final String f46148e = "[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.((\\p{Digit}+))([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*";

    public n(String str) {
        this.f46144a = str;
    }

    private boolean f() {
        return this.f46144a.startsWith("0x");
    }

    private boolean g() {
        return this.f46144a.length() > 1 && this.f46144a.charAt(0) == '0' && Character.isDigit(this.f46144a.charAt(1));
    }

    public boolean a() {
        return this.f46144a.matches("\\-?\\d+");
    }

    public Double b() {
        return Double.valueOf(Double.parseDouble(this.f46144a));
    }

    public Float c() {
        return Float.valueOf(Float.parseFloat(this.f46144a));
    }

    public Integer d() {
        return f() ? Integer.valueOf(Integer.parseInt(this.f46144a.substring(2), 16)) : g() ? Integer.valueOf(Integer.parseInt(this.f46144a.substring(1), 8)) : Integer.valueOf(Integer.parseInt(this.f46144a));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return b().doubleValue();
    }

    public Long e() {
        return f() ? Long.valueOf(Long.parseLong(this.f46144a.substring(2), 16)) : g() ? Long.valueOf(Long.parseLong(this.f46144a.substring(1), 8)) : Long.valueOf(Long.parseLong(this.f46144a));
    }

    @Override // java.lang.Number
    public float floatValue() {
        return c().floatValue();
    }

    @Override // java.lang.Number
    public int intValue() {
        return d().intValue();
    }

    @Override // java.lang.Number
    public long longValue() {
        return e().longValue();
    }
}
