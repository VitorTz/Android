package com.example.drawingapp

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View


class DrawingView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var drawPath: CustomPath? = null
    private var canvasBitmap: Bitmap? = null
    private var drawPaint: Paint? = null
    private var canvasPaint: Paint? = null
    private var canvas: Canvas? = null
    private var brushSize: Float = 0.toFloat()
    private var color: Int = Color.BLACK

    internal inner class CustomPath(var color: Int, var brushThickness: Float) : Path()

    init {
        this.setUp()
    }

    private fun setUp() {
        this.brushSize = 20.toFloat()
        this.drawPaint = Paint()
        this.drawPath = CustomPath(this.color, this.brushSize)
        this.drawPaint!!.color = this.color
        this.drawPaint!!.style = Paint.Style.STROKE
        this.drawPaint!!.strokeJoin = Paint.Join.ROUND
        this.drawPaint!!.strokeCap = Paint.Cap.ROUND
        this.canvasPaint = Paint(Paint.DITHER_FLAG)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        this.canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        this.canvas = Canvas(this.canvasBitmap!!)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(this.canvasBitmap!!, 0f, 0f, this.canvasPaint)
        if (!this.drawPath!!.isEmpty) {
            this.drawPaint!!.strokeWidth = this.drawPath!!.brushThickness
            this.drawPaint!!.color = this.drawPath!!.color
            canvas.drawPath(this.drawPath!!, this.drawPaint!!)
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val x = event?.x
        val y = event?.y
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                this.drawPath!!.color = this.color
                this.drawPath!!.brushThickness = this.brushSize
                this.drawPath!!.reset()
                this.drawPath!!.moveTo(x!!, y!!)
            }
            MotionEvent.ACTION_MOVE -> {
                this.drawPath!!.lineTo(x!!, y!!)
            }
            MotionEvent.ACTION_UP -> {
                this.drawPath = CustomPath(this.color, this.brushSize)
            }
            else -> return false
        }
        this.invalidate()
        return true
    }

}