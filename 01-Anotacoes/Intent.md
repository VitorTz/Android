# Intent

> Exemplo



```kotlin
val intent = Intent(this, QuizResultActivity::class.java)
intent.putExtra(Constants.USERNAME, this.intent.getStringExtra(Constants.USERNAME))
intent.putExtra(Constants.TOTAL_QUESTIONS, Constants.questions.size)
intent.putExtra(Constants.CORRECT_ANSWERS, Constants.questions.count { q -> q.correctAnswer == q.userAnswer })
this.startActivity(intent)
this.finish()
```


