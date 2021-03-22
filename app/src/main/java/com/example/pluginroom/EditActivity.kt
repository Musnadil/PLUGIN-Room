package com.example.pluginroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pluginroom.databinding.ActivityEditBinding
import com.example.pluginroom.room.Note
import com.example.pluginroom.room.NoteDB
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {

    val db by lazy { NoteDB(this) }

    private lateinit var binding : ActivityEditBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupListener()
    }
    fun setupListener(){
        button_save.setOnClickListener(){
            CoroutineScope(Dispatchers.IO).launch {
                db.noteDao().addNote(
                    Note (0,edit_title.text.toString(),edit_note.text.toString())
                )
                finish()
            }
        }
    }
}