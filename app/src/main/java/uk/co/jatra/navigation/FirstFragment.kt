package uk.co.jatra.navigation

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.first_fragment.*

const val REQUEST_CODE = 101

class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private lateinit var viewModel: AppViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.first_fragment, container, false)

        view.findViewById<Button>(R.id.button).setOnClickListener { button ->
            Navigation.findNavController(button).navigate(R.id.first_to_second)
        }

        return view
    }

    /**
     * Called when the fragment is visible to the user and actively running.
     * This is generally
     * tied to [Activity.onResume] of the containing
     * Activity's lifecycle.
     */
    override fun onResume() {
        super.onResume()
        result.text= viewModel.answer.toString()
        if (viewModel.answer != 0) {
            result.visibility = View.VISIBLE
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        result.text = resultCode.toString()
        result.visibility = if (requestCode == REQUEST_CODE) View.VISIBLE else View.GONE
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.application?.let {
            ViewModelFactory.instance(it)?.let {
                viewModel = ViewModelProviders.of(this, it).get(AppViewModel::class.java)
            }
        }
    }

}
