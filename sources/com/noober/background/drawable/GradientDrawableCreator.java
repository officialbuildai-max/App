package com.noober.background.drawable;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import com.noober.background.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class GradientDrawableCreator implements ICreateDrawable {
    private int gradientState;
    private TypedArray typedArray;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GradientDrawableCreator(TypedArray typedArray) {
        this.gradientState = -1;
        this.typedArray = typedArray;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GradientDrawableCreator(TypedArray typedArray, int i11) {
        this.typedArray = typedArray;
        this.gradientState = i11;
    }

    private boolean hasSetRadius(float[] fArr) {
        for (float f11 : fArr) {
            if (f11 != 0.0f) {
                return true;
            }
        }
        return false;
    }

    @Override // com.noober.background.drawable.ICreateDrawable
    public GradientDrawable create() throws XmlPullParserException {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float[] fArr = new float[8];
        Rect rect = new Rect();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = -1.0f;
        float f14 = 0.0f;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        while (i12 < this.typedArray.getIndexCount()) {
            int index = this.typedArray.getIndex(i12);
            if (index == R.styleable.background_bl_shape) {
                gradientDrawable.setShape(this.typedArray.getInt(index, i11));
            } else if (index == R.styleable.background_bl_solid_color) {
                i13 = this.typedArray.getColor(index, i11);
            } else if (index == R.styleable.background_bl_corners_radius) {
                gradientDrawable.setCornerRadius(this.typedArray.getDimension(index, 0.0f));
            } else if (index == R.styleable.background_bl_corners_bottomLeftRadius) {
                fArr[6] = this.typedArray.getDimension(index, 0.0f);
                fArr[7] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_bottomRightRadius) {
                fArr[4] = this.typedArray.getDimension(index, 0.0f);
                fArr[5] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_topLeftRadius) {
                fArr[0] = this.typedArray.getDimension(index, 0.0f);
                fArr[1] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_topRightRadius) {
                fArr[2] = this.typedArray.getDimension(index, 0.0f);
                fArr[3] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_leftRadius) {
                fArr[0] = this.typedArray.getDimension(index, 0.0f);
                fArr[1] = this.typedArray.getDimension(index, 0.0f);
                fArr[6] = this.typedArray.getDimension(index, 0.0f);
                fArr[7] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_topRadius) {
                fArr[0] = this.typedArray.getDimension(index, 0.0f);
                fArr[1] = this.typedArray.getDimension(index, 0.0f);
                fArr[2] = this.typedArray.getDimension(index, 0.0f);
                fArr[3] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_rightRadius) {
                fArr[2] = this.typedArray.getDimension(index, 0.0f);
                fArr[3] = this.typedArray.getDimension(index, 0.0f);
                fArr[4] = this.typedArray.getDimension(index, 0.0f);
                fArr[5] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_corners_bottomRadius) {
                fArr[4] = this.typedArray.getDimension(index, 0.0f);
                fArr[5] = this.typedArray.getDimension(index, 0.0f);
                fArr[6] = this.typedArray.getDimension(index, 0.0f);
                fArr[7] = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_gradient_angle || index == R.styleable.background_bl_checkable_gradient_angle || index == R.styleable.background_bl_unCheckable_gradient_angle || index == R.styleable.background_bl_checked_gradient_angle || index == R.styleable.background_bl_unChecked_gradient_angle || index == R.styleable.background_bl_enabled_gradient_angle || index == R.styleable.background_bl_unEnabled_gradient_angle || index == R.styleable.background_bl_selected_gradient_angle || index == R.styleable.background_bl_unSelected_gradient_angle || index == R.styleable.background_bl_pressed_gradient_angle || index == R.styleable.background_bl_unPressed_gradient_angle || index == R.styleable.background_bl_focused_gradient_angle || index == R.styleable.background_bl_unFocused_gradient_angle) {
                int i20 = this.gradientState;
                if (i20 == -1) {
                    i19 = this.typedArray.getInteger(index, 0);
                } else if (i20 == 16842911 && index == R.styleable.background_bl_checkable_gradient_angle) {
                    i19 = this.typedArray.getInteger(index, 0);
                } else if (i20 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_angle) {
                    i19 = this.typedArray.getInteger(index, 0);
                } else if (i20 == 16842912 && index == R.styleable.background_bl_checked_gradient_angle) {
                    i19 = this.typedArray.getInteger(index, 0);
                } else if (i20 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_angle) {
                    i19 = this.typedArray.getInteger(index, 0);
                } else if (i20 == 16842910 && index == R.styleable.background_bl_enabled_gradient_angle) {
                    i19 = this.typedArray.getInteger(index, 0);
                } else if (i20 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_angle) {
                    i19 = this.typedArray.getInteger(index, 0);
                } else if (i20 == 16842913 && index == R.styleable.background_bl_selected_gradient_angle) {
                    i19 = this.typedArray.getInteger(index, 0);
                } else if (i20 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_angle) {
                    i19 = this.typedArray.getInteger(index, 0);
                } else if (i20 == 16842919 && index == R.styleable.background_bl_pressed_gradient_angle) {
                    i19 = this.typedArray.getInteger(index, 0);
                } else if (i20 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_angle) {
                    i19 = this.typedArray.getInteger(index, 0);
                } else if (i20 == 16842908 && index == R.styleable.background_bl_focused_gradient_angle) {
                    i19 = this.typedArray.getInteger(index, 0);
                } else if (i20 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_angle) {
                    i19 = this.typedArray.getInteger(index, 0);
                }
            } else if (index == R.styleable.background_bl_gradient_centerX || index == R.styleable.background_bl_checkable_gradient_centerX || index == R.styleable.background_bl_unCheckable_gradient_centerX || index == R.styleable.background_bl_checked_gradient_centerX || index == R.styleable.background_bl_unChecked_gradient_centerX || index == R.styleable.background_bl_enabled_gradient_centerX || index == R.styleable.background_bl_unEnabled_gradient_centerX || index == R.styleable.background_bl_selected_gradient_centerX || index == R.styleable.background_bl_unSelected_gradient_centerX || index == R.styleable.background_bl_pressed_gradient_centerX || index == R.styleable.background_bl_unPressed_gradient_centerX || index == R.styleable.background_bl_focused_gradient_centerX || index == R.styleable.background_bl_unFocused_gradient_centerX) {
                int i21 = this.gradientState;
                if (i21 == -1) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                } else if (i21 == 16842911 && index == R.styleable.background_bl_checkable_gradient_centerX) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                } else if (i21 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_centerX) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                } else if (i21 == 16842912 && index == R.styleable.background_bl_checked_gradient_centerX) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                } else if (i21 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_centerX) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                } else if (i21 == 16842910 && index == R.styleable.background_bl_enabled_gradient_centerX) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                } else if (i21 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_centerX) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                } else if (i21 == 16842913 && index == R.styleable.background_bl_selected_gradient_centerX) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                } else if (i21 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_centerX) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                } else if (i21 == 16842919 && index == R.styleable.background_bl_pressed_gradient_centerX) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                } else if (i21 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_centerX) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                } else if (i21 == 16842908 && index == R.styleable.background_bl_focused_gradient_centerX) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                } else if (i21 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_centerX) {
                    f16 = this.typedArray.getFloat(index, -1.0f);
                }
            } else if (index == R.styleable.background_bl_gradient_centerY || index == R.styleable.background_bl_checkable_gradient_centerY || index == R.styleable.background_bl_unCheckable_gradient_centerY || index == R.styleable.background_bl_checked_gradient_centerY || index == R.styleable.background_bl_unChecked_gradient_centerY || index == R.styleable.background_bl_enabled_gradient_centerY || index == R.styleable.background_bl_unEnabled_gradient_centerY || index == R.styleable.background_bl_selected_gradient_centerY || index == R.styleable.background_bl_unSelected_gradient_centerY || index == R.styleable.background_bl_pressed_gradient_centerY || index == R.styleable.background_bl_unPressed_gradient_centerY || index == R.styleable.background_bl_focused_gradient_centerY || index == R.styleable.background_bl_unFocused_gradient_centerY) {
                int i22 = this.gradientState;
                if (i22 == -1) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                } else if (i22 == 16842911 && index == R.styleable.background_bl_checkable_gradient_centerY) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                } else if (i22 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_centerY) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                } else if (i22 == 16842912 && index == R.styleable.background_bl_checked_gradient_centerY) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                } else if (i22 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_centerY) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                } else if (i22 == 16842910 && index == R.styleable.background_bl_enabled_gradient_centerY) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                } else if (i22 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_centerY) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                } else if (i22 == 16842913 && index == R.styleable.background_bl_selected_gradient_centerY) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                } else if (i22 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_centerY) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                } else if (i22 == 16842919 && index == R.styleable.background_bl_pressed_gradient_centerY) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                } else if (i22 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_centerY) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                } else if (i22 == 16842908 && index == R.styleable.background_bl_focused_gradient_centerY) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                } else if (i22 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_centerY) {
                    f17 = this.typedArray.getFloat(index, -1.0f);
                }
            } else if (index == R.styleable.background_bl_gradient_centerColor || index == R.styleable.background_bl_checkable_gradient_centerColor || index == R.styleable.background_bl_unCheckable_gradient_centerColor || index == R.styleable.background_bl_checked_gradient_centerColor || index == R.styleable.background_bl_unChecked_gradient_centerColor || index == R.styleable.background_bl_enabled_gradient_centerColor || index == R.styleable.background_bl_unEnabled_gradient_centerColor || index == R.styleable.background_bl_selected_gradient_centerColor || index == R.styleable.background_bl_unSelected_gradient_centerColor || index == R.styleable.background_bl_pressed_gradient_centerColor || index == R.styleable.background_bl_unPressed_gradient_centerColor || index == R.styleable.background_bl_focused_gradient_centerColor || index == R.styleable.background_bl_unFocused_gradient_centerColor) {
                int i23 = this.gradientState;
                if (i23 == -1) {
                    i15 = this.typedArray.getColor(index, 0);
                } else if (i23 == 16842911 && index == R.styleable.background_bl_checkable_gradient_centerColor) {
                    i15 = this.typedArray.getColor(index, 0);
                } else if (i23 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_centerColor) {
                    i15 = this.typedArray.getColor(index, 0);
                } else if (i23 == 16842912 && index == R.styleable.background_bl_checked_gradient_centerColor) {
                    i15 = this.typedArray.getColor(index, 0);
                } else if (i23 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_centerColor) {
                    i15 = this.typedArray.getColor(index, 0);
                } else if (i23 == 16842910 && index == R.styleable.background_bl_enabled_gradient_centerColor) {
                    i15 = this.typedArray.getColor(index, 0);
                } else if (i23 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_centerColor) {
                    i15 = this.typedArray.getColor(index, 0);
                } else if (i23 == 16842913 && index == R.styleable.background_bl_selected_gradient_centerColor) {
                    i15 = this.typedArray.getColor(index, 0);
                } else if (i23 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_centerColor) {
                    i15 = this.typedArray.getColor(index, 0);
                } else if (i23 == 16842919 && index == R.styleable.background_bl_pressed_gradient_centerColor) {
                    i15 = this.typedArray.getColor(index, 0);
                } else if (i23 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_centerColor) {
                    i15 = this.typedArray.getColor(index, 0);
                } else if (i23 == 16842908 && index == R.styleable.background_bl_focused_gradient_centerColor) {
                    i15 = this.typedArray.getColor(index, 0);
                } else if (i23 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_centerColor) {
                    i15 = this.typedArray.getColor(index, 0);
                }
            } else if (index == R.styleable.background_bl_gradient_endColor || index == R.styleable.background_bl_checkable_gradient_endColor || index == R.styleable.background_bl_unCheckable_gradient_endColor || index == R.styleable.background_bl_checked_gradient_endColor || index == R.styleable.background_bl_unChecked_gradient_endColor || index == R.styleable.background_bl_enabled_gradient_endColor || index == R.styleable.background_bl_unEnabled_gradient_endColor || index == R.styleable.background_bl_selected_gradient_endColor || index == R.styleable.background_bl_unSelected_gradient_endColor || index == R.styleable.background_bl_pressed_gradient_endColor || index == R.styleable.background_bl_unPressed_gradient_endColor || index == R.styleable.background_bl_focused_gradient_endColor || index == R.styleable.background_bl_unFocused_gradient_endColor) {
                int i24 = this.gradientState;
                if (i24 == -1) {
                    i17 = this.typedArray.getColor(index, 0);
                } else if (i24 == 16842911 && index == R.styleable.background_bl_checkable_gradient_endColor) {
                    i17 = this.typedArray.getColor(index, 0);
                } else if (i24 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_endColor) {
                    i17 = this.typedArray.getColor(index, 0);
                } else if (i24 == 16842912 && index == R.styleable.background_bl_checked_gradient_endColor) {
                    i17 = this.typedArray.getColor(index, 0);
                } else if (i24 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_endColor) {
                    i17 = this.typedArray.getColor(index, 0);
                } else if (i24 == 16842910 && index == R.styleable.background_bl_enabled_gradient_endColor) {
                    i17 = this.typedArray.getColor(index, 0);
                } else if (i24 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_endColor) {
                    i17 = this.typedArray.getColor(index, 0);
                } else if (i24 == 16842913 && index == R.styleable.background_bl_selected_gradient_endColor) {
                    i17 = this.typedArray.getColor(index, 0);
                } else if (i24 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_endColor) {
                    i17 = this.typedArray.getColor(index, 0);
                } else if (i24 == 16842919 && index == R.styleable.background_bl_pressed_gradient_endColor) {
                    i17 = this.typedArray.getColor(index, 0);
                } else if (i24 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_endColor) {
                    i17 = this.typedArray.getColor(index, 0);
                } else if (i24 == 16842908 && index == R.styleable.background_bl_focused_gradient_endColor) {
                    i17 = this.typedArray.getColor(index, 0);
                } else if (i24 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_endColor) {
                    i17 = this.typedArray.getColor(index, 0);
                }
            } else if (index == R.styleable.background_bl_gradient_startColor || index == R.styleable.background_bl_checkable_gradient_startColor || index == R.styleable.background_bl_unCheckable_gradient_startColor || index == R.styleable.background_bl_checked_gradient_startColor || index == R.styleable.background_bl_unChecked_gradient_startColor || index == R.styleable.background_bl_enabled_gradient_startColor || index == R.styleable.background_bl_unEnabled_gradient_startColor || index == R.styleable.background_bl_selected_gradient_startColor || index == R.styleable.background_bl_unSelected_gradient_startColor || index == R.styleable.background_bl_pressed_gradient_startColor || index == R.styleable.background_bl_unPressed_gradient_startColor || index == R.styleable.background_bl_focused_gradient_startColor || index == R.styleable.background_bl_unFocused_gradient_startColor) {
                int i25 = this.gradientState;
                if (i25 == -1) {
                    i16 = this.typedArray.getColor(index, 0);
                } else if (i25 == 16842911 && index == R.styleable.background_bl_checkable_gradient_startColor) {
                    i16 = this.typedArray.getColor(index, 0);
                } else if (i25 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_startColor) {
                    i16 = this.typedArray.getColor(index, 0);
                } else if (i25 == 16842912 && index == R.styleable.background_bl_checked_gradient_startColor) {
                    i16 = this.typedArray.getColor(index, 0);
                } else if (i25 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_startColor) {
                    i16 = this.typedArray.getColor(index, 0);
                } else if (i25 == 16842910 && index == R.styleable.background_bl_enabled_gradient_startColor) {
                    i16 = this.typedArray.getColor(index, 0);
                } else if (i25 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_startColor) {
                    i16 = this.typedArray.getColor(index, 0);
                } else if (i25 == 16842913 && index == R.styleable.background_bl_selected_gradient_startColor) {
                    i16 = this.typedArray.getColor(index, 0);
                } else if (i25 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_startColor) {
                    i16 = this.typedArray.getColor(index, 0);
                } else if (i25 == 16842919 && index == R.styleable.background_bl_pressed_gradient_startColor) {
                    i16 = this.typedArray.getColor(index, 0);
                } else if (i25 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_startColor) {
                    i16 = this.typedArray.getColor(index, 0);
                } else if (i25 == 16842908 && index == R.styleable.background_bl_focused_gradient_startColor) {
                    i16 = this.typedArray.getColor(index, 0);
                } else if (i25 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_startColor) {
                    i16 = this.typedArray.getColor(index, 0);
                }
            } else if (index == R.styleable.background_bl_gradient_gradientRadius || index == R.styleable.background_bl_checkable_gradient_gradientRadius || index == R.styleable.background_bl_unCheckable_gradient_gradientRadius || index == R.styleable.background_bl_checked_gradient_gradientRadius || index == R.styleable.background_bl_unChecked_gradient_gradientRadius || index == R.styleable.background_bl_enabled_gradient_gradientRadius || index == R.styleable.background_bl_unEnabled_gradient_gradientRadius || index == R.styleable.background_bl_selected_gradient_gradientRadius || index == R.styleable.background_bl_unSelected_gradient_gradientRadius || index == R.styleable.background_bl_pressed_gradient_gradientRadius || index == R.styleable.background_bl_unPressed_gradient_gradientRadius || index == R.styleable.background_bl_focused_gradient_gradientRadius || index == R.styleable.background_bl_unFocused_gradient_gradientRadius) {
                int i26 = this.gradientState;
                if (i26 == -1) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i26 == 16842911 && index == R.styleable.background_bl_checkable_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i26 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i26 == 16842912 && index == R.styleable.background_bl_checked_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i26 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i26 == 16842910 && index == R.styleable.background_bl_enabled_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i26 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i26 == 16842913 && index == R.styleable.background_bl_selected_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i26 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i26 == 16842919 && index == R.styleable.background_bl_pressed_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i26 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i26 == 16842908 && index == R.styleable.background_bl_focused_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                } else if (i26 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_gradientRadius) {
                    gradientDrawable.setGradientRadius(this.typedArray.getDimension(index, 0.0f));
                }
            } else if (index == R.styleable.background_bl_gradient_type || index == R.styleable.background_bl_checkable_gradient_type || index == R.styleable.background_bl_unCheckable_gradient_type || index == R.styleable.background_bl_checked_gradient_type || index == R.styleable.background_bl_unChecked_gradient_type || index == R.styleable.background_bl_enabled_gradient_type || index == R.styleable.background_bl_unEnabled_gradient_type || index == R.styleable.background_bl_selected_gradient_type || index == R.styleable.background_bl_unSelected_gradient_type || index == R.styleable.background_bl_pressed_gradient_type || index == R.styleable.background_bl_unPressed_gradient_type || index == R.styleable.background_bl_focused_gradient_type || index == R.styleable.background_bl_unFocused_gradient_type) {
                int i27 = this.gradientState;
                if (i27 == -1) {
                    i18 = this.typedArray.getInt(index, 0);
                } else if (i27 == 16842911 && index == R.styleable.background_bl_checkable_gradient_type) {
                    i18 = this.typedArray.getInt(index, 0);
                } else if (i27 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_type) {
                    i18 = this.typedArray.getInt(index, 0);
                } else if (i27 == 16842912 && index == R.styleable.background_bl_checked_gradient_type) {
                    i18 = this.typedArray.getInt(index, 0);
                } else if (i27 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_type) {
                    i18 = this.typedArray.getInt(index, 0);
                } else if (i27 == 16842910 && index == R.styleable.background_bl_enabled_gradient_type) {
                    i18 = this.typedArray.getInt(index, 0);
                } else if (i27 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_type) {
                    i18 = this.typedArray.getInt(index, 0);
                } else if (i27 == 16842913 && index == R.styleable.background_bl_selected_gradient_type) {
                    i18 = this.typedArray.getInt(index, 0);
                } else if (i27 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_type) {
                    i18 = this.typedArray.getInt(index, 0);
                } else if (i27 == 16842919 && index == R.styleable.background_bl_pressed_gradient_type) {
                    i18 = this.typedArray.getInt(index, 0);
                } else if (i27 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_type) {
                    i18 = this.typedArray.getInt(index, 0);
                } else if (i27 == 16842908 && index == R.styleable.background_bl_focused_gradient_type) {
                    i18 = this.typedArray.getInt(index, 0);
                } else if (i27 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_type) {
                    i18 = this.typedArray.getInt(index, 0);
                }
                int i28 = i18;
                gradientDrawable.setGradientType(i28);
                i18 = i28;
            } else if (index == R.styleable.background_bl_gradient_useLevel || index == R.styleable.background_bl_checkable_gradient_useLevel || index == R.styleable.background_bl_unCheckable_gradient_useLevel || index == R.styleable.background_bl_checked_gradient_useLevel || index == R.styleable.background_bl_unChecked_gradient_useLevel || index == R.styleable.background_bl_enabled_gradient_useLevel || index == R.styleable.background_bl_unEnabled_gradient_useLevel || index == R.styleable.background_bl_selected_gradient_useLevel || index == R.styleable.background_bl_unSelected_gradient_useLevel || index == R.styleable.background_bl_pressed_gradient_useLevel || index == R.styleable.background_bl_unPressed_gradient_useLevel || index == R.styleable.background_bl_focused_gradient_useLevel || index == R.styleable.background_bl_unFocused_gradient_useLevel) {
                int i29 = this.gradientState;
                if (i29 == -1) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i29 == 16842911 && index == R.styleable.background_bl_checkable_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i29 == -16842911 && index == R.styleable.background_bl_unCheckable_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i29 == 16842912 && index == R.styleable.background_bl_checked_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i29 == -16842912 && index == R.styleable.background_bl_unChecked_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i29 == 16842910 && index == R.styleable.background_bl_enabled_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i29 == -16842910 && index == R.styleable.background_bl_unEnabled_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i29 == 16842913 && index == R.styleable.background_bl_selected_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i29 == -16842913 && index == R.styleable.background_bl_unSelected_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i29 == 16842919 && index == R.styleable.background_bl_pressed_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i29 == -16842919 && index == R.styleable.background_bl_unPressed_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i29 == 16842908 && index == R.styleable.background_bl_focused_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                } else if (i29 == -16842908 && index == R.styleable.background_bl_unFocused_gradient_useLevel) {
                    gradientDrawable.setUseLevel(this.typedArray.getBoolean(index, false));
                }
            } else if (index == R.styleable.background_bl_padding_left) {
                rect.left = (int) this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_padding_top) {
                rect.top = (int) this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_padding_right) {
                rect.right = (int) this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_padding_bottom) {
                rect.bottom = (int) this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_size_width) {
                f11 = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_size_height) {
                f12 = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_stroke_width) {
                f13 = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_stroke_color) {
                i14 = this.typedArray.getColor(index, 0);
            } else if (index == R.styleable.background_bl_stroke_dashWidth) {
                f14 = this.typedArray.getDimension(index, 0.0f);
            } else if (index == R.styleable.background_bl_stroke_dashGap) {
                f15 = this.typedArray.getDimension(index, 0.0f);
            }
            i12++;
            i11 = 0;
        }
        if (hasSetRadius(fArr)) {
            gradientDrawable.setCornerRadii(fArr);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_size_width) && this.typedArray.hasValue(R.styleable.background_bl_size_height)) {
            gradientDrawable.setSize((int) f11, (int) f12);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.typedArray.hasValue(R.styleable.background_bl_pressed_solid_color)) {
            arrayList.add(Integer.valueOf(android.R.attr.state_pressed));
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_pressed_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_unPressed_solid_color)) {
            arrayList.add(-16842919);
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unPressed_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_checkable_solid_color)) {
            arrayList.add(Integer.valueOf(android.R.attr.state_checkable));
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_checkable_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_unCheckable_solid_color)) {
            arrayList.add(-16842911);
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unCheckable_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_checked_solid_color)) {
            arrayList.add(Integer.valueOf(android.R.attr.state_checked));
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_checked_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_unChecked_solid_color)) {
            arrayList.add(-16842912);
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unChecked_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_enabled_solid_color)) {
            arrayList.add(Integer.valueOf(android.R.attr.state_enabled));
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_enabled_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_unEnabled_solid_color)) {
            arrayList.add(-16842910);
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unEnabled_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_selected_solid_color)) {
            arrayList.add(Integer.valueOf(android.R.attr.state_selected));
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_selected_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_unSelected_solid_color)) {
            arrayList.add(-16842913);
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unSelected_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_focused_solid_color)) {
            arrayList.add(Integer.valueOf(android.R.attr.state_focused));
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_focused_solid_color, 0)));
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_unFocused_solid_color)) {
            arrayList.add(-16842908);
            arrayList2.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unFocused_solid_color, 0)));
        }
        if (arrayList.size() > 0) {
            int size = arrayList.size();
            if (this.typedArray.hasValue(R.styleable.background_bl_solid_color)) {
                size++;
            }
            int[][] iArr = new int[size];
            int[] iArr2 = new int[size];
            Iterator it = arrayList.iterator();
            int i30 = 0;
            while (it.hasNext()) {
                iArr[i30] = new int[]{((Integer) it.next()).intValue()};
                iArr2[i30] = ((Integer) arrayList2.get(i30)).intValue();
                i30++;
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_solid_color)) {
                iArr[i30] = new int[0];
                iArr2[i30] = i13;
            }
            gradientDrawable.setColor(new ColorStateList(iArr, iArr2));
        } else if (this.typedArray.hasValue(R.styleable.background_bl_solid_color)) {
            gradientDrawable.setColor(i13);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_stroke_width)) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            if (this.typedArray.hasValue(R.styleable.background_bl_pressed_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unPressed_stroke_color)) {
                arrayList3.add(Integer.valueOf(android.R.attr.state_pressed));
                arrayList3.add(-16842919);
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_pressed_stroke_color, 0)));
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unPressed_stroke_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_checkable_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unCheckable_stroke_color)) {
                arrayList3.add(Integer.valueOf(android.R.attr.state_checkable));
                arrayList3.add(-16842911);
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_checkable_stroke_color, 0)));
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unCheckable_stroke_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_checked_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unChecked_stroke_color)) {
                arrayList3.add(Integer.valueOf(android.R.attr.state_checked));
                arrayList3.add(-16842912);
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_checked_stroke_color, 0)));
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unChecked_stroke_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_enabled_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unEnabled_stroke_color)) {
                arrayList3.add(Integer.valueOf(android.R.attr.state_enabled));
                arrayList3.add(-16842910);
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_enabled_stroke_color, 0)));
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unEnabled_stroke_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_selected_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unSelected_stroke_color)) {
                arrayList3.add(Integer.valueOf(android.R.attr.state_selected));
                arrayList3.add(-16842913);
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_selected_stroke_color, 0)));
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unSelected_stroke_color, 0)));
            }
            if (this.typedArray.hasValue(R.styleable.background_bl_focused_stroke_color) && this.typedArray.hasValue(R.styleable.background_bl_unFocused_stroke_color)) {
                arrayList3.add(Integer.valueOf(android.R.attr.state_focused));
                arrayList3.add(-16842908);
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_focused_stroke_color, 0)));
                arrayList4.add(Integer.valueOf(this.typedArray.getColor(R.styleable.background_bl_unFocused_stroke_color, 0)));
            }
            if (arrayList3.size() > 0) {
                int[][] iArr3 = new int[arrayList3.size()];
                int[] iArr4 = new int[arrayList3.size()];
                Iterator it2 = arrayList3.iterator();
                int i31 = 0;
                while (it2.hasNext()) {
                    iArr3[i31] = new int[]{((Integer) it2.next()).intValue()};
                    iArr4[i31] = ((Integer) arrayList4.get(i31)).intValue();
                    i31++;
                }
                gradientDrawable.setStroke((int) f13, new ColorStateList(iArr3, iArr4), f14, f15);
            } else if (this.typedArray.hasValue(R.styleable.background_bl_stroke_color)) {
                gradientDrawable.setStroke((int) f13, i14, f14, f15);
            }
        }
        if ((this.typedArray.hasValue(R.styleable.background_bl_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_checkable_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unCheckable_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_checked_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unChecked_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_enabled_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unEnabled_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_selected_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unSelected_gradient_centerY)) || ((this.typedArray.hasValue(R.styleable.background_bl_pressed_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unPressed_gradient_centerY)) || (this.typedArray.hasValue(R.styleable.background_bl_focused_gradient_centerX) && this.typedArray.hasValue(R.styleable.background_bl_unFocused_gradient_centerY)))))))) {
            gradientDrawable.setGradientCenter(f16, f17);
        }
        if ((this.typedArray.hasValue(R.styleable.background_bl_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_checkable_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unCheckable_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_checked_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unChecked_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_enabled_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unEnabled_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_selected_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unSelected_gradient_endColor)) || ((this.typedArray.hasValue(R.styleable.background_bl_pressed_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unPressed_gradient_endColor)) || (this.typedArray.hasValue(R.styleable.background_bl_focused_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unFocused_gradient_endColor)))))))) {
            gradientDrawable.setColors(this.typedArray.hasValue(R.styleable.background_bl_gradient_centerColor) ? new int[]{i16, i15, i17} : new int[]{i16, i17});
        }
        if (i18 == 0 && (this.typedArray.hasValue(R.styleable.background_bl_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_checkable_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_checked_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_enabled_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_selected_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_pressed_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_focused_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unCheckable_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unChecked_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unEnabled_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unSelected_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unPressed_gradient_angle) || this.typedArray.hasValue(R.styleable.background_bl_unFocused_gradient_angle))) {
            int i32 = i19 % 360;
            if (i32 % 45 != 0) {
                throw new XmlPullParserException(this.typedArray.getPositionDescription() + "<gradient> tag requires 'angle' attribute to be a multiple of 45");
            }
            GradientDrawable.Orientation orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            if (i32 != 0) {
                if (i32 == 45) {
                    orientation = GradientDrawable.Orientation.BL_TR;
                } else if (i32 == 90) {
                    orientation = GradientDrawable.Orientation.BOTTOM_TOP;
                } else if (i32 == 135) {
                    orientation = GradientDrawable.Orientation.BR_TL;
                } else if (i32 == 180) {
                    orientation = GradientDrawable.Orientation.RIGHT_LEFT;
                } else if (i32 == 225) {
                    orientation = GradientDrawable.Orientation.TR_BL;
                } else if (i32 == 270) {
                    orientation = GradientDrawable.Orientation.TOP_BOTTOM;
                } else if (i32 == 315) {
                    orientation = GradientDrawable.Orientation.TL_BR;
                }
            }
            gradientDrawable.setOrientation(orientation);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_padding_left) && this.typedArray.hasValue(R.styleable.background_bl_padding_top) && this.typedArray.hasValue(R.styleable.background_bl_padding_right) && this.typedArray.hasValue(R.styleable.background_bl_padding_bottom)) {
            if (Build.VERSION.SDK_INT >= 29) {
                gradientDrawable.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            } else {
                try {
                    Field declaredField = gradientDrawable.getClass().getDeclaredField("mPadding");
                    declaredField.setAccessible(true);
                    declaredField.set(gradientDrawable, rect);
                } catch (IllegalAccessException e11) {
                    e11.printStackTrace();
                } catch (NoSuchFieldException e12) {
                    e12.printStackTrace();
                }
            }
        }
        return gradientDrawable;
    }
}
