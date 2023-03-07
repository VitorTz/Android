package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.quizapp.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionsBinding
    private lateinit var questionList: QuestionList
    private lateinit var buttons: List<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityQuestionsBinding.inflate(this.layoutInflater)
        setContentView(this.binding.root)
        this.supportActionBar?.hide()

        this.questionList = QuestionList()
        this.buttons = listOf(
            this.binding.answer1,
            this.binding.answer2,
            this.binding.answer3,
            this.binding.answer4
        )

        this.reset()


        this.binding.answer1.setOnClickListener {
            this.markAnswer(it, 0)
        }

        this.binding.answer2.setOnClickListener {
            this.markAnswer(it, 1)
        }

        this.binding.answer3.setOnClickListener {
            this.markAnswer(it, 2)
        }

        this.binding.answer4.setOnClickListener {
            this.markAnswer(it, 3)
        }

        this.binding.prevBtn.setOnClickListener {
            this.changeCurrentQuestion(it, -1)
        }

        this.binding.nextBtn.setOnClickListener {
            this.changeCurrentQuestion(it, +1)
        }

        this.binding.resetBtn.setOnClickListener {
            this.reset()
        }

        this.binding.checkBtn.setOnClickListener { it ->
            if (!this.questionList.isAllQuestionsAnswered())
                CustomSnackBar.show(this, it, this.resources.getString(R.string.unansweredQuestions))
            else {
                val intent = Intent(this, QuizResultActivity::class.java)
                intent.putExtra(Constants.USERNAME, this.intent.getStringExtra(Constants.USERNAME))
                intent.putExtra(Constants.TOTAL_QUESTIONS, Constants.questions.size)
                intent.putExtra(Constants.CORRECT_ANSWERS, Constants.questions.count { q -> q.correctAnswer == q.userAnswer })
                this.startActivity(intent)
                this.finish()
            }
        }

    }

    private fun showCurrentQuestion() {
        val q: Question = this.questionList.getCurrentQuestion()
        this.binding.flagImg.setImageResource(q.image)
        this.binding.answer1.text = "1) ".plus(q.answer1)
        this.binding.answer2.text = "2) ".plus(q.answer2)
        this.binding.answer3.text = "3) ".plus(q.answer3)
        this.binding.answer4.text = "4) ".plus(q.answer4)
    }

    private fun reset() {
        this.questionList.reset()
        this.showCurrentQuestion()
        this.resetButtonsBackground()
        this.binding.progressBar.max = Constants.questions.size
        this.binding.progressBar.setProgress(0, false)
    }

    private fun showAnswer() {
        val q: Question = this.questionList.getCurrentQuestion()
        if (q.answered) {
            val buttonCorrectAnswer: TextView = this.buttons[q.correctAnswer]
            val buttonUserAnswer: TextView = this.buttons[q.userAnswer!!]
            buttonUserAnswer.setBackgroundResource(R.drawable.incorrect_answer)
            buttonCorrectAnswer.setBackgroundResource(R.drawable.correct_answer)
        }
    }

    private fun updateProgressBar() {
        this.binding.progressBar.setProgress(Globals.answeredQuestions, true)
    }

    private fun markAnswer(view: View, answer: Int) {
        val q: Question = this.questionList.getCurrentQuestion()
        if (!q.answered) {
            q.answered = true
            q.userAnswer = answer
            Globals.answeredQuestions += 1
            this.showAnswer()
            this.updateProgressBar()
        } else
            CustomSnackBar.show(this, view, this.resources.getString(R.string.aleradyAnswered))
    }

    private fun resetButtonsBackground() {
        this.buttons.forEach { it.setBackgroundResource(R.drawable.answer) }
    }

    private fun changeCurrentQuestion(view: View, delta: Int) {
        if (this.questionList.isAllQuestionsAnswered())
            CustomSnackBar.show(this, view, this.resources.getString(R.string.allQuestionsAnswered))
        else {
            this.questionList.changeCurrentQuestion(delta)
            this.showCurrentQuestion()
            this.resetButtonsBackground()
        }
    }
}