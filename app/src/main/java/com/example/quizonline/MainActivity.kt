package com.example.quizonline
//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
//import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizonline.databinding.ActivityMainBinding
//import com.google.firebase.database.FirebaseDatabase



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var quizModelList : MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizModelList = mutableListOf()
        getDataFromFirebase()
    }

    private fun setupRecyclerView(){
       binding.progressBar.visibility = View.GONE
        adapter = QuizListAdapter(quizModelList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

//    private fun getDataFromFirebase(){
//        binding.progressBar.visibility = View.VISIBLE
//        FirebaseDatabase.getInstance().reference
//            .get()
//            .addOnSuccessListener { dataSnapshot->
//                if(dataSnapshot.exists()){
//                    for (snapshot in dataSnapshot.children){
//                        val quizModel = snapshot.getValue(QuizModel::class.java)
//                        if (quizModel != null) {
//                            quizModelList.add(quizModel)
//                        }
//                    }
//                }
//                setupRecyclerView()
//            }


//    }


    private fun getDataFromFirebase(){

        val listQuestionModel = mutableListOf<QuestionModel>()

        listQuestionModel.add(QuestionModel("Who is the CEO of Google",mutableListOf("Elon musk ","Sundar Pichai","Satiya Nadella","Bill Gates"),"Sundar Pichai" ))
        listQuestionModel.add(QuestionModel("Who is the CEO of spacex",mutableListOf("Elon musk ","Sundar Pichai","Satiya Nadella","Bill Gates"),"Elon musk" ))
        listQuestionModel.add(QuestionModel("Who is the CEO of tesla",mutableListOf("Elon musk ","Sundar Pichai","Satiya Nadella","Bill Gates"),"Elon musk" ))
        listQuestionModel.add(QuestionModel("Who is the CEO of Microsoft",mutableListOf("Elon musk ","Sundar Pichai","Satiya Nadella","Bill Gates"),"satiya Nadella" ))

        val listQuestionModel2 = mutableListOf<QuestionModel>()

        listQuestionModel2.add(QuestionModel("Who is the president of USA",mutableListOf("Donald Trump ","Narander Modi","Biden","Putin"),"Donald Trump" ))
        listQuestionModel2.add(QuestionModel("Who is the former president of USA",mutableListOf("Donald Trump ","Narander Modi","Biden","Putin"),"Biden" ))
        listQuestionModel2.add(QuestionModel("Who is the Prime Minister of India",mutableListOf("Donald Trump ","Narander Modi","Biden","Putin"),"Narander Modi" ))
        listQuestionModel2.add(QuestionModel("Who is the president of Russia",mutableListOf("Donald Trump ","Narander Modi","Biden","Putin"),"Putin" ))

        quizModelList.add(QuizModel("General Knowledge ","Tech","10",listQuestionModel))
        quizModelList.add(QuizModel("Politics","World","10",listQuestionModel2))
        setupRecyclerView()

    }
}
