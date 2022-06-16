package com.example.android.projectimagepuzzle

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class ImagePuzzleTest
{
    @Test
    fun useAppContext()
    {
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("me.liuqingwen.android.projectimagepuzzle", appContext.packageName)
    }
    
    @Test
    fun image_drawable_test()
    {
        val fragment = FragmentImagePuzzle.newInstance()
    }
}
