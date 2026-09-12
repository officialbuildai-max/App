package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* loaded from: classes5.dex */
public class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static Map<Character, Character> f35796a;

    /* renamed from: b, reason: collision with root package name */
    private static Map<Character, Character> f35797b;

    /* renamed from: c, reason: collision with root package name */
    private static byte[] f35798c = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* renamed from: d, reason: collision with root package name */
    private static char[] f35799d = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    static {
        HashMap hashMap = new HashMap();
        f35796a = hashMap;
        hashMap.put('v', 'A');
        f35796a.put('S', 'B');
        f35796a.put('o', 'C');
        f35796a.put('a', 'D');
        f35796a.put('j', 'E');
        f35796a.put('c', 'F');
        f35796a.put('7', 'G');
        f35796a.put('d', 'H');
        f35796a.put('R', 'I');
        f35796a.put('z', 'J');
        f35796a.put('p', 'K');
        f35796a.put('W', 'L');
        f35796a.put('i', 'M');
        f35796a.put('f', 'N');
        f35796a.put('G', 'O');
        f35796a.put('y', 'P');
        f35796a.put('N', 'Q');
        f35796a.put('x', 'R');
        f35796a.put('Z', 'S');
        f35796a.put('n', 'T');
        f35796a.put('V', 'U');
        f35796a.put('5', 'V');
        f35796a.put('k', 'W');
        f35796a.put('+', 'X');
        f35796a.put('D', 'Y');
        f35796a.put('H', 'Z');
        f35796a.put('L', 'a');
        f35796a.put('Y', 'b');
        f35796a.put('h', 'c');
        f35796a.put('J', 'd');
        f35796a.put('4', 'e');
        f35796a.put('6', 'f');
        f35796a.put('l', 'g');
        f35796a.put('t', 'h');
        f35796a.put('0', 'i');
        f35796a.put('U', 'j');
        f35796a.put('3', 'k');
        f35796a.put('Q', 'l');
        f35796a.put('r', 'm');
        f35796a.put('g', 'n');
        f35796a.put('E', 'o');
        f35796a.put('u', 'p');
        f35796a.put('q', 'q');
        f35796a.put('8', 'r');
        f35796a.put('s', 's');
        f35796a.put('w', 't');
        f35796a.put('/', 'u');
        f35796a.put('X', 'v');
        f35796a.put('M', 'w');
        f35796a.put('e', 'x');
        f35796a.put('B', 'y');
        f35796a.put('A', 'z');
        f35796a.put('T', '0');
        f35796a.put('2', '1');
        f35796a.put('F', '2');
        f35796a.put('b', '3');
        f35796a.put('9', '4');
        f35796a.put('P', '5');
        f35796a.put('1', '6');
        f35796a.put('O', '7');
        f35796a.put('I', '8');
        f35796a.put('K', '9');
        f35796a.put('m', '+');
        f35796a.put('C', '/');
        HashMap hashMap2 = new HashMap();
        f35797b = hashMap2;
        hashMap2.put('A', 'v');
        f35797b.put('B', 'S');
        f35797b.put('C', 'o');
        f35797b.put('D', 'a');
        f35797b.put('E', 'j');
        f35797b.put('F', 'c');
        f35797b.put('G', '7');
        f35797b.put('H', 'd');
        f35797b.put('I', 'R');
        f35797b.put('J', 'z');
        f35797b.put('K', 'p');
        f35797b.put('L', 'W');
        f35797b.put('M', 'i');
        f35797b.put('N', 'f');
        f35797b.put('O', 'G');
        f35797b.put('P', 'y');
        f35797b.put('Q', 'N');
        f35797b.put('R', 'x');
        f35797b.put('S', 'Z');
        f35797b.put('T', 'n');
        f35797b.put('U', 'V');
        f35797b.put('V', '5');
        f35797b.put('W', 'k');
        f35797b.put('X', '+');
        f35797b.put('Y', 'D');
        f35797b.put('Z', 'H');
        f35797b.put('a', 'L');
        f35797b.put('b', 'Y');
        f35797b.put('c', 'h');
        f35797b.put('d', 'J');
        f35797b.put('e', '4');
        f35797b.put('f', '6');
        f35797b.put('g', 'l');
        f35797b.put('h', 't');
        f35797b.put('i', '0');
        f35797b.put('j', 'U');
        f35797b.put('k', '3');
        f35797b.put('l', 'Q');
        f35797b.put('m', 'r');
        f35797b.put('n', 'g');
        f35797b.put('o', 'E');
        f35797b.put('p', 'u');
        f35797b.put('q', 'q');
        f35797b.put('r', '8');
        f35797b.put('s', 's');
        f35797b.put('t', 'w');
        f35797b.put('u', '/');
        f35797b.put('v', 'X');
        f35797b.put('w', 'M');
        f35797b.put('x', 'e');
        f35797b.put('y', 'B');
        f35797b.put('z', 'A');
        f35797b.put('0', 'T');
        f35797b.put('1', '2');
        f35797b.put('2', 'F');
        f35797b.put('3', 'b');
        f35797b.put('4', '9');
        f35797b.put('5', 'P');
        f35797b.put('6', '1');
        f35797b.put('7', 'O');
        f35797b.put('8', 'I');
        f35797b.put('9', 'K');
        f35797b.put('+', 'm');
        f35797b.put('/', 'C');
    }

    public static String a(String str) {
        return p0.b(str);
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : p0.c(str);
    }
}
