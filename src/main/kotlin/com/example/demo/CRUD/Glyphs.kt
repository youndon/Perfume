package com.example.demo.CRUD

import org.controlsfx.glyphfont.FontAwesome
import org.controlsfx.glyphfont.Glyph
import org.controlsfx.glyphfont.GlyphFont
import org.controlsfx.glyphfont.GlyphFontRegistry

object Glyphs {
    private val fontAwesome: GlyphFont = GlyphFontRegistry.font("FontAwesome")
    val saveGlyph: Glyph = fontAwesome.create(FontAwesome.Glyph.SAVE)
    val removeGlyph: Glyph = fontAwesome.create(FontAwesome.Glyph.REMOVE)
    val signInGlyph: Glyph = fontAwesome.create(FontAwesome.Glyph.SIGN_IN)
    val signOutGlyph: Glyph = fontAwesome.create(FontAwesome.Glyph.SIGN_OUT)
}